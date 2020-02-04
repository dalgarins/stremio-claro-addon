package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.category.CategoryDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClaroVideoApi {

    @GET("/services/cms/level")
    Call<CategoryDTO> categories(@Query(value = "node", encoded = true) String type);

}
