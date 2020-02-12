package co.anbora.labs.claro.data.remote.api.rest;

import co.anbora.labs.claro.data.remote.model.category.CategoryDTO;
import co.anbora.labs.claro.data.remote.model.media.VideoMediaDTO;
import co.anbora.labs.claro.data.remote.model.purchase.PurchaseDTO;
import co.anbora.labs.claro.data.remote.model.video.VideosDTO;
import retrofit2.Call;
import retrofit2.http.*;

public interface ClaroVideoApi {

    @GET("/services/cms/level")
    Call<CategoryDTO> categories(@Query(value = "node", encoded = true) String type);

    @GET("/services/content/list")
    Call<VideosDTO> movies(@Query(value = "from") String from,
                           @Query(value = "quantity") String quantity,
                           @Query(value = "filter_id") String filterId);

    @GET("/services/payway/purchasebuttoninfo")
    Call<PurchaseDTO> purchase(@Query(value = "group_id") String movieId);

    @POST("/services/payway/getmedia")
    Call<VideoMediaDTO> stream(@Query(value = "group_id") String movieId,
                               @Field(value = "user_token") String userToken,
                               @Field(value = "payway_token") String payWayToken);
}
