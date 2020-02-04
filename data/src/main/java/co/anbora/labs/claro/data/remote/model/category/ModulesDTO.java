package co.anbora.labs.claro.data.remote.model.category;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ModulesDTO {

    @SerializedName("module")
    private List<ModuleDTO> modules = new ArrayList<>();

    @Data
    public static class ModuleDTO {

        @SerializedName("name")
        private String name;
        @SerializedName("type")
        private String type;
        @SerializedName("components")
        private ComponentsDTO components;

    }
}
