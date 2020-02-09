package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.category.GetCategoriesUseCase;
import co.anbora.labs.claro.domain.usecase.login.GetCookiesUseCase;
import co.anbora.labs.claro.domain.usecase.videos.GetVideoByIdUseCase;
import co.anbora.labs.claro.domain.usecase.videos.GetVideosUseCase;
import co.anbora.labs.claro.domain.usecase.videos.SyncRemoteVideosUseCase;
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

    @Bean
    @Singleton
    GetCategoriesUseCase provideGetCategoriesUseCase(IClaroVideoRepository claroVideoRepository) {
        return new GetCategoriesUseCase(claroVideoRepository);
    }

    @Bean
    @Singleton
    GetVideoByIdUseCase provideGetVideoByIdUseCase(IAddOnRepository addOnRepository) {
        return new GetVideoByIdUseCase(addOnRepository);
    }

    @Bean
    @Singleton
    GetVideosUseCase provideGetVideosUseCase(IAddOnRepository addOnRepository) {
        return new GetVideosUseCase(addOnRepository);
    }

    @Bean
    @Singleton
    SyncRemoteVideosUseCase provideSyncRemoteVideosUseCase(IClaroVideoRepository claroVideoRepository) {
        return new SyncRemoteVideosUseCase(claroVideoRepository);
    }

}
