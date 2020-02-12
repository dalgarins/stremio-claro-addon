package co.anbora.labs.claro.data.remote.model.responses;

import co.anbora.labs.claro.data.remote.model.purchase.PlayButtonDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResponsePurchaseDTO {

    @SerializedName("playButton")
    private PlayButtonDTO playButtonDTO = new PlayButtonDTO();

}
