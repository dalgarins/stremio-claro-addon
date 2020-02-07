package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.VideoDTO;
import co.anbora.labs.claro.data.remote.model.video.GroupVideoDTO;
import co.anbora.labs.claro.data.remote.model.video.VideosDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VideosDTOtoListMapper implements Function<VideosDTO, List<VideoDTO>> {
    @Override
    public List<VideoDTO> apply(VideosDTO videosDTO) {
        List<VideoDTO> videos = new ArrayList<>();
        if (Objects.nonNull(videosDTO)) {
            videos = getGroupVideos(videosDTO)
                    .stream().map(this::transform)
                    .collect(Collectors.toList());
        }
        return videos;
    }

    private List<GroupVideoDTO> getGroupVideos(VideosDTO videosDTO) {
        return videosDTO.getResponse()
                .getGroupVideos();
    }

    private VideoDTO transform(GroupVideoDTO groupVideoDTO) {
        return new VideoDTO(
                groupVideoDTO.getId(),
                groupVideoDTO.getTitle(),
                groupVideoDTO.getOriginalTitle(),
                groupVideoDTO.getDescription(),
                groupVideoDTO.getMediumImage(),
                groupVideoDTO.getLargeImage(),
                groupVideoDTO.getDuration(),
                groupVideoDTO.getYear()
        );
    }
}
