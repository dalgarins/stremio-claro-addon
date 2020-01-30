package co.anbora.labs.claro.addon;

import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
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
    GetCookiesUseCase getCookiesUseCase;

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
}