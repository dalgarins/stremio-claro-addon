package co.anbora.labs.claro.data.remote.model.responses;

import co.anbora.labs.claro.data.remote.model.category.ModulesDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ResponseCategoryDTO {

    @SerializedName("modules")
    private ModulesDTO module;

}
