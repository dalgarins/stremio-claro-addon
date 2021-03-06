package co.anbora.labs.claro.injection;

import co.anbora.labs.claro.data.remote.api.interceptors.AuthenticationInterceptor;
import co.anbora.labs.claro.data.remote.api.interceptors.AuthorizationInterceptor;
import co.anbora.labs.claro.data.remote.api.rest.ClaroAPAWebApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroColombiaConfigApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroLoginWebApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroVideoApi;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.injection.qualifiers.Auth;
import co.anbora.labs.claro.injection.qualifiers.ConfigApi;
import co.anbora.labs.claro.injection.qualifiers.VideoApi;
import co.anbora.labs.claro.injection.qualifiers.WebApi;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

import static co.anbora.labs.claro.injection.UntrustedSSLClient.getUnsafeOkHttpClient;

@Factory
public class NetworkModule {

    @Bean
    @Singleton
    ClaroColombiaConfigApi provideClaroColombiaConfigApi(@ConfigApi Retrofit retrofit) {
        return retrofit.create(ClaroColombiaConfigApi.class);
    }

    @Bean
    @ConfigApi
    @Singleton
    Retrofit provideRetrofitConfig(@Property(name = "claro.url_config") String urlConfig) {
        OkHttpClient okHttpClient = getUnsafeOkHttpClient();

        return new Retrofit.Builder()
                .baseUrl(urlConfig)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    @Singleton
    ClaroAPAWebApi provideClaroApaApi(@WebApi Retrofit retrofit) {
        return retrofit.create(ClaroAPAWebApi.class);
    }

    @Bean
    @WebApi
    @Singleton
    Retrofit provideRetrofitApaApi(@Property(name = "claro.url_apa") String urlApa) {
        OkHttpClient okHttpClient = getUnsafeOkHttpClient();

        return new Retrofit.Builder()
                .baseUrl(urlApa)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    @Singleton
    ClaroLoginWebApi provideClaroLoginWebApi(@Auth Retrofit retrofit) {
        return retrofit.create(ClaroLoginWebApi.class);
    }

    @Bean
    @Auth
    @Singleton
    Retrofit provideRetrofitWithAuth(@Property(name = "claro.url_mfwk_api") String urlMFWK, AuthenticationInterceptor authInterceptor) {
        OkHttpClient okHttpClient = getUnsafeOkHttpClient()
                .newBuilder()
                .addInterceptor(authInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(urlMFWK)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Bean
    @Singleton
    AuthenticationInterceptor provideAuthInterceptor(ClaroColombiaConfigApi colombiaConfigApi, ClaroAPAWebApi apaWebApi) {
        return new AuthenticationInterceptor(colombiaConfigApi, apaWebApi);
    }

    @Bean
    @Singleton
    AuthorizationInterceptor provideAuthorizationInterceptor(TokenDao tokenDao) {
        return new AuthorizationInterceptor(tokenDao);
    }

    @Bean
    @Singleton
    ClaroVideoApi provideClaroVideoApi(@VideoApi Retrofit retrofit) {
        return retrofit.create(ClaroVideoApi.class);
    }

    @Bean
    @VideoApi
    @Singleton
    Retrofit provideRetrofitWithAuth(@Property(name = "claro.url_mfwk_api") String urlMFWK, AuthorizationInterceptor authorizationInterceptor) {
        OkHttpClient okHttpClient = getUnsafeOkHttpClient()
                .newBuilder()
                .addInterceptor(authorizationInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(urlMFWK)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

}