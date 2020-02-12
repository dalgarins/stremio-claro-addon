package co.anbora.labs.claro.domain.constants;

import co.anbora.labs.claro.domain.model.stremio.Catalog;

public class StremioConstants {

    private StremioConstants() {}

    public interface Plugin {
        String ID = "co.anbora.labs.claro.videos";
        String VERSION = "1.0.0";
        String NAME = "Claro Videos";
        String DESCRIPTION = "Plugin for Claro videos Colombia";
        String[] ID_PREFIXES = null;
        String[] RESOURCES = new String[] {"catalog", "stream"};
        String[] TYPES = new String[] {"movie"};
        Catalog[] CATALOGS = new Catalog[] {new Catalog(StremioCatalog.MOVIE, StremioCatalog.ID_CATALOG, "Claro Movies Catalog", new String[] {}, new String[0], new String[] {"search"})};
        String BACKGROUND = "";
        String LOGO = "https://upload.wikimedia.org/wikipedia/commons/0/0e/LogoClaroVid.png";
        String CONTACT_EMAIL = "anboralabs@gmail.com";
    }

    public interface StremioCatalog {
        String ID_CATALOG = "claroCatalog";
        String MOVIE = "movie";
    }

}
