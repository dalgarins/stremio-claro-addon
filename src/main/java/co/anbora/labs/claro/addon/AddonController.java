package co.anbora.labs.claro.addon;

import co.anbora.labs.claro.domain.model.stremio.CatalogContainer;
import co.anbora.labs.claro.domain.model.stremio.Manifest;
import co.anbora.labs.claro.domain.model.stremio.Stream;
import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.stremio.GetAllCatalogUseCase;
import co.anbora.labs.claro.domain.usecase.stremio.GetCatalogByExtraUseCase;
import co.anbora.labs.claro.domain.usecase.stremio.GetStreamByIdUseCase;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

@Controller()
public class AddonController {

    @Inject
    UseCaseExecutor useCaseExecutor;
    @Inject
    GetAllCatalogUseCase getAllCatalogUseCase;
    @Inject
    GetCatalogByExtraUseCase getCatalogByExtraUseCase;
    @Inject
    GetStreamByIdUseCase getStreamByIdUseCase;
    @Inject
    Manifest manifest;

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get("/manifest.json")
    public CompletableFuture<Manifest> manifest() {
        return CompletableFuture.supplyAsync(() -> manifest);
    }

    @Get("/catalog/{type}/{id}.json")
    public CompletableFuture<CatalogContainer> allVideos(String type, String id) {
        return useCaseExecutor.execute(getAllCatalogUseCase,
                new GetAllCatalogUseCase.Request(type, id),
                GetAllCatalogUseCase.Response::getCatalogContainer
        );
    }

    @Get("/catalog/{type}/{id}/{extra}.json")
    public CompletableFuture<CatalogContainer> searchVideos(String type, String id, String extra) {
        return useCaseExecutor.execute(getCatalogByExtraUseCase,
                new GetCatalogByExtraUseCase.Request(type, id, extra),
                GetCatalogByExtraUseCase.Response::getCatalogContainer);
    }

    @Get("/stream/{type}/{id}.json")
    public CompletableFuture<Stream> stream(String type, String id) {
        return useCaseExecutor.execute(getStreamByIdUseCase,
                new GetStreamByIdUseCase.Request(type, id),
                GetStreamByIdUseCase.Response::getStream);
    }
}