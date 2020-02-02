package co.anbora.labs.claro.data.remote.model.login;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import co.anbora.labs.claro.data.remote.model.requests.ResponseLoginDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoginDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

    @SerializedName("response")
    private ResponseLoginDTO response;

}
