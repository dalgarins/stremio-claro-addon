package co.anbora.labs.claro.data.remote.model.responses;

import co.anbora.labs.claro.data.remote.model.video.GroupVideoDTO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseVideoDTO {

    @SerializedName("groups")
    private List<GroupVideoDTO> groupVideos = new ArrayList<>();

}
