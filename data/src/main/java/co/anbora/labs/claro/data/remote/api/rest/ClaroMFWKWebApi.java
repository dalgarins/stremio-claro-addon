package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClaroMFWKWebApi {

    @GET("/services/user/login")
    Call<LoginDTO> login(@Query(value = "username", encoded = true) String userName,
                         @Query(value = "password", encoded = true) String password);

}
