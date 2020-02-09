package co.anbora.labs.claro.addon;

import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.category.GetCategoriesUseCase;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import co.anbora.labs.claro.domain.usecase.videos.GetVideosUseCase;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller()
public class AddonController {

    @Inject
    UseCaseExecutor useCaseExecutor;
    @Inject
    GetCookiesUseCase getCookiesUseCase;
    @Inject
    GetCategoriesUseCase getCategoriesUseCase;
    @Inject
    GetVideosUseCase getVideosUseCase;

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get("/cookie")
    public CompletableFuture<LoginToken> cookie() {
        return useCaseExecutor.execute(getCookiesUseCase,
                new GetCookiesUseCase.Request(),
                GetCookiesUseCase.Response::getLoginToken);
    }

    @Get("/categories")
    public CompletableFuture<List<CategoryVideo>> categories() {
        return useCaseExecutor.execute(getCategoriesUseCase,
                new GetCategoriesUseCase.Request("sapeliculas"),
                GetCategoriesUseCase.Response::getCategoryVideos);
    }

    @Get("/videos")
    public CompletableFuture<List<Video>> videos() {
        return useCaseExecutor.execute(getVideosUseCase,
                new GetVideosUseCase.Request(),
                GetVideosUseCase.Response::getVideos);
    }
}