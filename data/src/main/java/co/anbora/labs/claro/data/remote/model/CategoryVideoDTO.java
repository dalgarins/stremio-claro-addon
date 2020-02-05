package co.anbora.labs.claro.data.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static co.anbora.labs.claro.domain.constants.Constants.*;

@Data
@AllArgsConstructor
public class CategoryVideoDTO {

    private String name;
    private String url;

    public String getFormattedUrl() {
        return this.url.replace(SERVICE_PATH_CATEGORY, EMPTY_VALUE);
    }

}
