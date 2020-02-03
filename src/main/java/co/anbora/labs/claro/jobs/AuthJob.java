package co.anbora.labs.claro.jobs;

import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.function.Function;

@Singleton
public class AuthJob {

    @Inject
    UseCaseExecutor useCaseExecutor;
    @Inject
    GetCookiesUseCase getCookiesUseCase;

    @Scheduled(fixedRate = "1440m")
    public void process() {
        useCaseExecutor.execute(getCookiesUseCase,
                new GetCookiesUseCase.Request(),
                Function.identity()
        );
    }
}