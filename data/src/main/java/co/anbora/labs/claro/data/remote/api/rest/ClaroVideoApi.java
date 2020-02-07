package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.category.CategoryDTO;
import co.anbora.labs.claro.data.remote.model.video.VideosDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClaroVideoApi {

    @GET("/services/cms/level")
    Call<CategoryDTO> categories(@Query(value = "node", encoded = true) String type);

    @GET("/services/content/list")
    Call<VideosDTO> movies(@Query(value = "from") String from,
                           @Query(value = "quantity") String quantity,
                           @Query(value = "filter_id") String filterId);

}
