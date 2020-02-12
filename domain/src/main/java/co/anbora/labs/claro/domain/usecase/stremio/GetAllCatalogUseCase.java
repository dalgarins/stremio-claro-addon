package co.anbora.labs.claro.domain.usecase.stremio;

import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.model.stremio.CatalogContainer;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import java.util.List;

import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.ID_CATALOG;
import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.MOVIE;

public class GetAllCatalogUseCase extends UseCase<GetAllCatalogUseCase.Request, GetAllCatalogUseCase.Response>{

    private IAddOnRepository repository;

    public GetAllCatalogUseCase(IAddOnRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        if (MOVIE.equals(input.type) && ID_CATALOG.equals(input.id)) {
            CatalogContainer catalogContainer = new CatalogContainer();
            List<Video> videos = repository.getAllVideos();
            videos.forEach(catalogContainer::addMovie);
            return new Response(catalogContainer);
        }
        return new Response(null);
    }

    @Value
    public static class Request implements UseCase.InputValues {
        private String type;
        private String id;
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private CatalogContainer catalogContainer;
    }
}
