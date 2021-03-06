package co.anbora.labs.claro.domain.model.stremio;
import co.anbora.labs.claro.domain.model.Movie;
import co.anbora.labs.claro.domain.model.claro.Video;

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

    public void addMovie(Video video) {
        metas.add(new Movie(video.getId(), video.getTitle(),
                video.getUrlImageMedium(), video.getDescription()));
    }
}