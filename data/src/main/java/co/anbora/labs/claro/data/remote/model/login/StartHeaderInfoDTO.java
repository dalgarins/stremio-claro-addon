package co.anbora.labs.claro.data.remote.model.login;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Setter;

@Data
public class StartHeaderInfoDTO {

    @Setter
    @SerializedName("response")
    private Response response;

    public String getHKS() {
        return response.getSessionStringValue();
    }

    @Data
    class Response {
        @SerializedName("region")
        private String region;
        @SerializedName("session_stringvalue")
        private String sessionStringValue;
        @SerializedName("session_parametername")
        private String sessionParameterName;
        @SerializedName("date")
        private String date;
        @SerializedName("time")
        private String time;
        @SerializedName("timezone")
        private String timeZone;
        @SerializedName("utc")
        private int utc;
    }

}
