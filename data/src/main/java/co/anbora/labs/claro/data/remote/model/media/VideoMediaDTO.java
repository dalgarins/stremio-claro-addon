package co.anbora.labs.claro.data.remote.model.media;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import co.anbora.labs.claro.data.remote.model.responses.ResponseVideoMediaDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VideoMediaDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

    @SerializedName("response")
    private ResponseVideoMediaDTO response;
}
