package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.remote.ClaroVideoRepositoryImpl;
import co.anbora.labs.claro.data.remote.api.rest.ClaroLoginWebApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroVideoApi;
import co.anbora.labs.claro.data.remote.managers.CategoryManager;
import co.anbora.labs.claro.data.remote.managers.LoginManager;
import co.anbora.labs.claro.data.remote.mapper.CategoryDTOtoListMapper;
import co.anbora.labs.claro.data.remote.mapper.CategoryVideoDTOtoVOMapper;
import co.anbora.labs.claro.data.remote.mapper.ListCategoryVideoDTOtoVOMapper;
import co.anbora.labs.claro.data.remote.mapper.LoginDTOMapper;
import co.anbora.labs.claro.data.repository.dao.category.CategoryDao;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.mapper.CategoryVOMapper;
import co.anbora.labs.claro.data.repository.mapper.ListCategoryVOMapper;
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
    LoginManager provideLoginManager(Credential credential,
                                     LoginDTOMapper dbTokenMapper,
                                     LoginVOMapper tokenMapper,
                                     ClaroLoginWebApi loginApi,
                                     TokenDao tokenDao) {
        return new LoginManager(credential, dbTokenMapper, tokenMapper, loginApi, tokenDao);
    }

    @Bean
    IClaroVideoRepository provideRemoteRepository(LoginManager loginManager,
                                                  CategoryManager categoryManager) {
        return new ClaroVideoRepositoryImpl(loginManager, categoryManager);
    }

    @Bean
    @Singleton
    CategoryDTOtoListMapper provideCategoryDTOtoListMapper() {
        return new CategoryDTOtoListMapper();
    }

    @Bean
    @Singleton
    CategoryVideoDTOtoVOMapper provideCategoryVideoDTOtoVOMapper() {
        return new CategoryVideoDTOtoVOMapper();
    }

    @Bean
    @Singleton
    ListCategoryVideoDTOtoVOMapper provideListCategoryVideoDTOtoVOMapper(CategoryVideoDTOtoVOMapper mapper) {
        return new ListCategoryVideoDTOtoVOMapper(mapper);
    }

    @Bean
    @Singleton
    CategoryVOMapper provideCategoryVOMapper() {
        return new CategoryVOMapper();
    }

    @Bean
    @Singleton
    ListCategoryVOMapper provideListCategoryVOMapper(CategoryVOMapper categoryVOMapper) {
        return new ListCategoryVOMapper(categoryVOMapper);
    }

    @Bean
    CategoryManager provideCategoryManager(CategoryDTOtoListMapper categoryDTOtoListMapper,
                                           ListCategoryVideoDTOtoVOMapper categoryListVideoDTOtoVOMapper,
                                           ListCategoryVOMapper listCategoryVOMapper,
                                           ClaroVideoApi claroVideoApi,
                                           CategoryDao categoryDao) {
        return new CategoryManager(categoryDTOtoListMapper, categoryListVideoDTOtoVOMapper,
                listCategoryVOMapper, claroVideoApi, categoryDao);
    }


}
