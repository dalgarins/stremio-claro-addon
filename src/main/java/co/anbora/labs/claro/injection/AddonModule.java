package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.usecases.UseCaseExecutorImpl;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class AddonModule {

    @Bean
    @Singleton
    UseCaseExecutor provideUseCaseExecutor() {
        return new UseCaseExecutorImpl();
    }

}
