package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.login.ConfigColombiaDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClaroColombiaConfigApi {

    @GET("/api/config/colombia")
    Call<ConfigColombiaDTO> colombia();

}
