package co.anbora.labs.claro.data.remote.model.requests;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResponseLoginDTO {

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
