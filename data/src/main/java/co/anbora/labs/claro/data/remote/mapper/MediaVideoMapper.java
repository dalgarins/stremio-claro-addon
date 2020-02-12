package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.media.VideoMediaDTO;
import co.anbora.labs.claro.domain.model.claro.StreamMedia;

import java.util.Objects;
import java.util.function.Function;

public class MediaVideoMapper implements Function<VideoMediaDTO, StreamMedia> {
    @Override
    public StreamMedia apply(VideoMediaDTO videoMediaDTO) {
        if (Objects.nonNull(videoMediaDTO)) {
            return StreamMedia.builder()
                    .urlVideo(videoMediaDTO.getResponse().getMedia().getVideoUrl())
                    .uuid(videoMediaDTO.getResponse().getUuid())
                    .build();
        }
        return null;
    }
}
