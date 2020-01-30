package co.anbora.labs.claro.data.remote.model.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EntryRequestDTO {

    @SerializedName("api_version")
    private String apiVersion;
    @SerializedName("authpn")
    private String authPN;
    @SerializedName("authpt")
    private String authPT;
    @SerializedName("format")
    private String format;
    @SerializedName("HKS")
    private String HKS;

}
