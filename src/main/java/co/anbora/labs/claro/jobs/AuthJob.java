package co.anbora.labs.claro.jobs;

import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.category.GetCategoriesUseCase;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import io.micronaut.context.annotation.Property;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Singleton
public class AuthJob {

    @Inject
    UseCaseExecutor useCaseExecutor;
    @Inject
    GetCookiesUseCase getCookiesUseCase;
    @Inject
    GetCategoriesUseCase getCategoriesUseCase;
    @Property(name = "claro.node_movies")
    String nodeMovies;

    @Scheduled(fixedRate = "1440m")
    public void process() {
        login().thenApply(this::getCategories);
    }

    private CompletableFuture<GetCookiesUseCase.Response> login() {
        return useCaseExecutor.execute(getCookiesUseCase,
                new GetCookiesUseCase.Request(),
                Function.identity()
        );
    }

    private CompletableFuture<GetCategoriesUseCase.Response> getCategories(
            GetCookiesUseCase.Response cookies) {
        return useCaseExecutor.execute(getCategoriesUseCase,
                new GetCategoriesUseCase.Request(nodeMovies),
                Function.identity());
    }
}