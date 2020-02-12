package co.anbora.labs.claro.data.remote.model.media;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MediaDTO {

    @SerializedName("video_url")
    private String videoUrl;
    @SerializedName("server_url")
    private String serverUrl;
    @SerializedName("challenge")
    private String challenge;

}
