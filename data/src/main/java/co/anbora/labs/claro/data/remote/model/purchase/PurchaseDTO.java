package co.anbora.labs.claro.data.remote.model.purchase;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import co.anbora.labs.claro.data.remote.model.responses.ResponsePurchaseDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PurchaseDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

    @SerializedName("response")
    private ResponsePurchaseDTO response;

    public String getPayWayToken() {
        return response.getPlayButtonDTO().getPayWayToken();
    }
}
