package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.remote.ClaroVideoRepositoryImpl;
import co.anbora.labs.claro.data.remote.api.rest.ClaroLoginWebApi;
import co.anbora.labs.claro.data.remote.mapper.LoginDTOMapper;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.mapper.LoginVOMapper;
import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;

@Factory
public class DataModule {

    @Bean
    @Singleton
    LoginDTOMapper provideDBTokenMapper() {
        return new LoginDTOMapper();
    }

    @Bean
    @Singleton
    LoginVOMapper provideTokenMapper() {
        return new LoginVOMapper();
    }

    @Bean
    IClaroVideoRepository provideRemoteRepository(Credential credential,
                                                  LoginDTOMapper dbTokenMapper,
                                                  LoginVOMapper tokenMapper,
                                                  ClaroLoginWebApi loginApi,
                                                  TokenDao tokenDao) {
        return new ClaroVideoRepositoryImpl(credential, dbTokenMapper, tokenMapper, loginApi, tokenDao);
    }


}
