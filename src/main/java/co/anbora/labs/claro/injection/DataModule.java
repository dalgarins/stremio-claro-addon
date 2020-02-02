package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.remote.ClaroVideoRepositoryImpl;
import co.anbora.labs.claro.data.remote.api.rest.ClaroMFWKWebApi;
import co.anbora.labs.claro.data.remote.mapper.LoginDTOMapper;
import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class DataModule {

    @Bean
    @Singleton
    LoginDTOMapper provideLoginToTokenMapper() {
        return new LoginDTOMapper();
    }

    @Bean
    IClaroVideoRepository provideRemoteRepository(Credential credential, LoginDTOMapper loginDTOMapper, ClaroMFWKWebApi loginApi) {
        return new ClaroVideoRepositoryImpl(credential, loginDTOMapper, loginApi);
    }


}
