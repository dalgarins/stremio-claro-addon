package co.anbora.labs.claro.data.remote.model.responses;

import co.anbora.labs.claro.data.remote.model.media.MediaDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResponseVideoMediaDTO {

    @SerializedName("stream_uuid")
    private String uuid;
    @SerializedName("media")
    private MediaDTO media;

}
