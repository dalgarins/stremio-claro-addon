package co.anbora.labs.claro.domain.model.claro;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Video {

    private String id;
    private String title;
    private String description;
    private String urlImageMedium;
    private String duration;
    private String released;
    private String year;

}
