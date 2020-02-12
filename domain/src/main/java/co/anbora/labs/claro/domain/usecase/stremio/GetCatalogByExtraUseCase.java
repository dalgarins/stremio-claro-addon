package co.anbora.labs.claro.domain.usecase.stremio;

import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.model.stremio.CatalogContainer;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import java.util.List;

import static co.anbora.labs.claro.domain.constants.Constants.EMPTY_VALUE;
import static co.anbora.labs.claro.domain.constants.Constants.EQUAL_CHARACTER;
import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.ID_CATALOG;
import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.MOVIE;

public class GetCatalogByExtraUseCase extends UseCase<GetCatalogByExtraUseCase.Request, GetCatalogByExtraUseCase.Response>{

    private IAddOnRepository repository;

    public GetCatalogByExtraUseCase(IAddOnRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        if (MOVIE.equals(input.type) && ID_CATALOG.equals(input.id)) {
            String[] search = input.extra.split(EQUAL_CHARACTER);
            String searchInput = EMPTY_VALUE;
            if (search.length > 1) {
                searchInput = search[1];
            }
            return new Response(getContainerBySearch(searchInput));
        }
        return new Response(null);
    }

    private CatalogContainer getContainerBySearch(String search) {
        CatalogContainer catalogContainer = new CatalogContainer();
        List<Video> videos = repository.getAllVideos();
        videos.stream()
                .filter(video -> video.getDescription().contains(search))
                .forEach(catalogContainer::addMovie);
        return catalogContainer;
    }

    @Value
    public static class Request implements UseCase.InputValues {
        private String type;
        private String id;
        private String extra;
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private CatalogContainer catalogContainer;
    }
}
