package co.anbora.labs.claro.domain.model;

import co.anbora.labs.claro.domain.model.stremio.MetaItem;

public class Movie extends MetaItem {
    public Movie(String id, String name, String poster, String description) {
        super(id, "movie", name, poster, description);
    }
}
