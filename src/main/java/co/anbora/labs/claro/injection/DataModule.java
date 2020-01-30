package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.remote.ClaroVideoRepositoryImpl;
import co.anbora.labs.claro.data.remote.api.rest.ClaroMFWKWebApi;
import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import java.util.function.Function;

@Factory
public class DataModule {

    @Bean
    IClaroVideoRepository provideRemoteRepository(ClaroMFWKWebApi loginApi) {
        return new ClaroVideoRepositoryImpl(new Function<LoginDTO, LoginToken>() {
            @Override
            public LoginToken apply(LoginDTO loginDTO) {
                return null;
            }
        }, loginApi);
    }


}
