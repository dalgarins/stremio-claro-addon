package co.anbora.labs.claro.data.remote.model.category;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class  ComponentsDTO {

    @SerializedName("component")
    private List<ComponentDTO> components = new ArrayList<>();

    @Data
    public static class ComponentDTO {

        @SerializedName("name")
        private String name;
        @SerializedName("type")
        private String type;
        @SerializedName("properties")
        private PropertyDTO property;

    }
}
