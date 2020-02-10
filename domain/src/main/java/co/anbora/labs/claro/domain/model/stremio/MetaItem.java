package co.anbora.labs.claro.domain.model.stremio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaItem {

    protected String id;
    protected String type;
    protected String name;
    protected String poster;
    protected String description;

}
