package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.VideoDTO;
import co.anbora.labs.claro.data.repository.model.VideoVO;

import java.util.Objects;
import java.util.function.Function;

public class VideoDTOtoVOMapper implements Function<VideoDTO, VideoVO> {
    @Override
    public VideoVO apply(VideoDTO videoDTO) {
        if (Objects.nonNull(videoDTO)) {
            return new VideoVO(
                videoDTO.getId(),
                videoDTO.getTitle(),
                videoDTO.getOriginalTitle(),
                videoDTO.getDescription(),
                videoDTO.getUrlImageMedium(),
                videoDTO.getUrlImageLarge(),
                videoDTO.getDuration(),
                videoDTO.getYear()
            );
        }
        return null;
    }
}
