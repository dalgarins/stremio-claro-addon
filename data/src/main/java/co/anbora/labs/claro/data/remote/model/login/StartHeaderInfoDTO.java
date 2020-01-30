package co.anbora.labs.claro.data.remote.model.login;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class StartHeaderInfoDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

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
