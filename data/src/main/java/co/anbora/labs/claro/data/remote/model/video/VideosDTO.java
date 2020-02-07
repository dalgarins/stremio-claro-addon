package co.anbora.labs.claro.data.remote.model.video;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import co.anbora.labs.claro.data.remote.model.responses.ResponseVideoDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VideosDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

    @SerializedName("response")
    private ResponseVideoDTO response = new ResponseVideoDTO();

}
