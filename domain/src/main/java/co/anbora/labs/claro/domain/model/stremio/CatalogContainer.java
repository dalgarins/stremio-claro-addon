package co.anbora.labs.claro.domain.model.stremio;
import co.anbora.labs.claro.domain.model.Movie;

import java.util.LinkedList;
import java.util.List;

public class CatalogContainer {
    private List<MetaItem> metas = new LinkedList<>();

    /**
     * @return the metas
     */
    public List<MetaItem> getMetas() {
        return metas;
    }

    public void addMovie(String id, String name, String poster, String description) {
        metas.add(new Movie(id, name, poster, description));
    }
}