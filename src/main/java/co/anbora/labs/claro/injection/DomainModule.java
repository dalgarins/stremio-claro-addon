package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;

import javax.inject.Singleton;

@Factory
public class DomainModule {

    @Bean
    @Singleton
    Credential provideClaroCredential(@Property(name = "claro.user") String username,
                                      @Property(name = "claro.password") String password) {
        return new Credential(username, password);
    }

    @Bean
    @Singleton
    GetCookiesUseCase provideGetCookiesUseCase(IClaroVideoRepository claroVideoRepository) {
        return new GetCookiesUseCase(claroVideoRepository);
    }

}
