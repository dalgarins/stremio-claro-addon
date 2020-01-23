package co.anbora.labs.claro.data.remote.model.login;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginDTO {

    @SerializedName("entry")
    private Entry entry;

    @SerializedName("response")
    private Response response;

    @Data
    class Entry {
        @SerializedName("authpn")
        private String authPN;
        @SerializedName("authpt")
        private String authPT;
        @SerializedName("HKS")
        private String HKS;
        @SerializedName("api_version")
        private String apiVersion;
    }

    @Data
    class Response {
        @SerializedName("user_id")
        private String userId;
        @SerializedName("username")
        private String userName;
        @SerializedName("firstname")
        private String firstName;
        @SerializedName("lastname")
        private String lastName;
        @SerializedName("session_userhash")
        private String userHash;
        @SerializedName("user_token")
        private String userToken;
        @SerializedName("user_session")
        private String userSession;
    }
}
