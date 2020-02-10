package co.anbora.labs.claro.data.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoDTO {

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
