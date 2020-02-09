package co.anbora.labs.claro.data.repository;

import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.dao.video.VideoDao;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.data.repository.model.VideoVO;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddOnRepositoryImpl implements IAddOnRepository {

    private TokenDao localTokenDao;
    private Function<LoginTokenVO, LoginToken> loginTokenVOMapper;
    private VideoDao videoDao;
    private Function<VideoVO, Video> videoVOMapper;

    public AddOnRepositoryImpl(TokenDao localTokenDao,
                               Function<LoginTokenVO, LoginToken> loginTokenVOMapper,
                               VideoDao videoDao,
                               Function<VideoVO, Video> videoVOMapper) {
        this.localTokenDao = localTokenDao;
        this.loginTokenVOMapper = loginTokenVOMapper;
        this.videoDao = videoDao;
        this.videoVOMapper = videoVOMapper;
    }

    @Override
    public LoginToken getCurrentToken() {
        return loginTokenVOMapper.apply(
                localTokenDao.findLastToken()
        );
    }

    @Override
    public Video getVideoById(String id) {
        return videoVOMapper.apply(
                videoDao.findById(id)
        );
    }

    @Override
    public List<Video> getAllVideos() {
        return videoDao.findAll()
                .stream()
                .map(videoVOMapper)
                .collect(Collectors.toList());
    }
}
