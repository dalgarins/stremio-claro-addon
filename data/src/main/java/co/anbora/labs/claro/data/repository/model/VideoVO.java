package co.anbora.labs.claro.data.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VideoVO {

    private String id;
    private String title;
    private String originalTitle;
    private String description;
    private String urlImageMedium;
    private String urlImageLarge;
    private String duration;
    private String released;
    private String year;

}
