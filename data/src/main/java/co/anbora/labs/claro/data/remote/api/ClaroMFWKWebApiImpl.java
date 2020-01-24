package co.anbora.labs.claro.data.remote.api;

import co.anbora.labs.claro.data.remote.api.interceptors.AuthInterceptor;
import co.anbora.labs.claro.data.remote.api.rest.ClaroMFWKWebApi;
import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class ClaroMFWKWebApiImpl implements ClaroMFWKWebApi {

    private ClaroMFWKWebApi claroMFWKWebApi;

    public ClaroMFWKWebApiImpl(String url, AuthInterceptor authInterceptor) {

        Interceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .build();

        claroMFWKWebApi = retrofit.create(ClaroMFWKWebApi.class);

    }

    @Override
    public LoginDTO login() {
        return this.claroMFWKWebApi.login();
    }
}
