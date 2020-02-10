package co.anbora.labs.claro.data.repository.mapper;

import co.anbora.labs.claro.data.repository.model.VideoVO;
import co.anbora.labs.claro.domain.model.claro.Video;

import java.util.Objects;
import java.util.function.Function;

public class VideoVOMapper implements Function<VideoVO, Video> {
    @Override
    public Video apply(VideoVO videoVO) {
        if (Objects.nonNull(videoVO)) {
            return Video.builder()
                    .id(videoVO.getId())
                    .description(videoVO.getDescription())
                    .title(videoVO.getTitle())
                    .duration(videoVO.getDuration())
                    .urlImageMedium(videoVO.getUrlImageMedium())
                    .released(videoVO.getReleased())
                    .year(videoVO.getYear())
                    .build();
        }
        return null;
    }
}
