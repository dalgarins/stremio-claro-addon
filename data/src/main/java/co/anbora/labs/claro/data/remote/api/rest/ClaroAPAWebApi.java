package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.login.StartHeaderInfoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClaroAPAWebApi {

    @GET("/services/user/startheaderinfo")
    Call<StartHeaderInfoDTO> getHeaderInfo(@Query("api_version") String apiVersion
            , @Query("authpn") String authPN, @Query("authpt") String authPT);

}
