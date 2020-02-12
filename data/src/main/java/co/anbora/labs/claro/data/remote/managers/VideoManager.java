package co.anbora.labs.claro.data.remote.managers;

import co.anbora.labs.claro.data.remote.api.rest.ClaroVideoApi;
import co.anbora.labs.claro.data.remote.model.VideoDTO;
import co.anbora.labs.claro.data.remote.model.media.VideoMediaDTO;
import co.anbora.labs.claro.data.remote.model.purchase.PurchaseDTO;
import co.anbora.labs.claro.data.remote.model.video.VideosDTO;
import co.anbora.labs.claro.data.repository.dao.category.CategoryDao;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.dao.video.VideoDao;
import co.anbora.labs.claro.data.repository.model.CategoryVO;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.data.repository.model.VideoVO;
import co.anbora.labs.claro.domain.exceptions.MediaNotFoundException;
import co.anbora.labs.claro.domain.model.claro.StreamMedia;
import co.anbora.labs.claro.domain.model.claro.Video;
import com.jasongoodwin.monads.Try;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VideoManager {

    private Function<VideosDTO, List<VideoDTO>> mapper;
    private Function<VideoDTO, VideoVO> mapperDTOtoVO;
    private Function<VideoVO, Video> mapperVO;
    private Function<VideoMediaDTO, StreamMedia> streamMediaMapper;

    private ClaroVideoApi claroVideoApi;
    private CategoryDao categoryDao;
    private VideoDao videoDao;
    private TokenDao tokenDao;


    public VideoManager(Function<VideosDTO, List<VideoDTO>> mapper,
                        Function<VideoDTO, VideoVO> mapperDTOtoVO,
                        Function<VideoVO, Video> mapperVO,
                        Function<VideoMediaDTO, StreamMedia> streamMediaMapper,
                        ClaroVideoApi claroVideoApi,
                        CategoryDao categoryDao,
                        VideoDao videoDao,
                        TokenDao tokenDao) {
        this.mapper = mapper;
        this.mapperDTOtoVO = mapperDTOtoVO;
        this.mapperVO = mapperVO;
        this.streamMediaMapper = streamMediaMapper;
        this.claroVideoApi = claroVideoApi;
        this.categoryDao = categoryDao;
        this.videoDao = videoDao;
        this.tokenDao = tokenDao;
    }

    public List<Video> videos() {
        List<CompletableFuture<VideosDTO>> futures = getVideosFutures();
        List<VideoVO> videosVo = processRequests(futures);
        videoDao.insert(videosVo);
        return videosVo.stream().map(mapperVO).collect(Collectors.toList());
    }

    private List<VideoVO> processRequests(List<CompletableFuture<VideosDTO>> futures) {
        return Stream.of(futures)
                .flatMap(Collection::stream)
                .map(CompletableFuture::join)
                .map(mapper)
                .flatMap(Collection::stream)
                .map(mapperDTOtoVO)
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<VideosDTO>> getVideosFutures() {
        List<CategoryVO> categories = categoryDao.findAll();
        List<CompletableFuture<VideosDTO>> futures = new ArrayList<>();
        categories.forEach( categoryVO ->
                futures.add(CompletableFuture.supplyAsync(() ->
                        Try.ofFailable(() -> claroVideoApi.movies(categoryVO.getFrom(),
                                categoryVO.getQuantity(), categoryVO.getFilterId()).execute().body())
                                .recover(throwable -> new VideosDTO())
                ))
        );
        return futures;
    }

    public StreamMedia streamMediaById(String videoId) {
        return validatePurchase(videoId)
                .flatMap(purchase -> getVideoMedia(videoId, purchase))
                .map(streamMediaMapper)
                .orElseThrow(MediaNotFoundException::new);
    }

    private Optional<PurchaseDTO> validatePurchase(String videoId) {
        return Try.ofFailable(() -> claroVideoApi.purchase(videoId).execute().body()).toOptional();
    }

    private Optional<VideoMediaDTO> getVideoMedia(String videoId, PurchaseDTO purchaseDTO) {
        LoginTokenVO loginTokenVO = tokenDao.findLastToken();
        return Try.ofFailable(() -> claroVideoApi.stream(videoId, loginTokenVO.getUserToken(),
                purchaseDTO.getPayWayToken()).execute().body()).toOptional();
    }
}
