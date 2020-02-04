package co.anbora.labs.claro.data.remote.model.category;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PropertyDTO {

    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("artist")
    private String artist;
    @SerializedName("ordinal")
    private String ordinal;
    @SerializedName("byuser")
    private String byUser;

}
