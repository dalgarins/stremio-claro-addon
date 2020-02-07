package co.anbora.labs.claro.data.remote.model.video;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GroupVideoDTO {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("title_original")
    private String originalTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("description_large")
    private String largeDescription;
    @SerializedName("image_small")
    private String smallImage;
    @SerializedName("image_medium")
    private String mediumImage;
    @SerializedName("image_large")
    private String largeImage;
    @SerializedName("duration")
    private String duration;
    @SerializedName("year")
    private String year;

}
