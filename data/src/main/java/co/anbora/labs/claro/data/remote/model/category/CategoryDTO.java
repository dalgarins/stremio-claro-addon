package co.anbora.labs.claro.data.remote.model.category;

import co.anbora.labs.claro.data.remote.model.requests.EntryRequestDTO;
import co.anbora.labs.claro.data.remote.model.responses.ResponseCategoryDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CategoryDTO {

    @SerializedName("entry")
    private EntryRequestDTO entry;

    @SerializedName("response")
    private ResponseCategoryDTO response;

}
