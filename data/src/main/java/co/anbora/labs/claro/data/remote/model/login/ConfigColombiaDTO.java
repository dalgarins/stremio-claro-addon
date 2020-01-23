package co.anbora.labs.claro.data.remote.model.login;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ConfigColombiaDTO {

    @SerializedName("url_dominio_microfwk")
    private String urlDominioMicrofwk;
    @SerializedName("authpn")
    private String authPN;
    @SerializedName("authpt")
    private String authPT;
    @SerializedName("api_version")
    private String apiVersion;

}
