package co.anbora.labs.claro.data.remote.model.purchase;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PlayButtonDTO {

    @SerializedName("purchaseid")
    private String purchaseId;
    @SerializedName("waspurchased")
    private String purchased;
    @SerializedName("visible")
    private String visible;
    @SerializedName("payway_token")
    private String payWayToken;

}
