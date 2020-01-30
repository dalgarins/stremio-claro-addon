package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class DomainModule {

    @Bean
    @Singleton
    GetCookiesUseCase provideGetCookiesUseCase(IClaroVideoRepository claroVideoRepository) {
        return new GetCookiesUseCase(claroVideoRepository);
    }

}
