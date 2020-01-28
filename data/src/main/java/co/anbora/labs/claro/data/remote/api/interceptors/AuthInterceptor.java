package co.anbora.labs.claro.data.remote.api.interceptors;

import co.anbora.labs.claro.data.remote.api.rest.ClaroAPAWebApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroColombiaConfigApi;
import co.anbora.labs.claro.data.remote.model.login.ConfigColombiaDTO;
import co.anbora.labs.claro.data.remote.model.login.StartHeaderInfoDTO;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {

    private ClaroColombiaConfigApi claroColombiaConfigApi;
    private ClaroAPAWebApi webApi;

    public AuthInterceptor(ClaroColombiaConfigApi colombiaConfigApi, ClaroAPAWebApi webApi) {
        this.claroColombiaConfigApi = colombiaConfigApi;
        this.webApi = webApi;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        retrofit2.Response<ConfigColombiaDTO> colombiaConfig = claroColombiaConfigApi
                .colombia().execute();

        if (colombiaConfig.isSuccessful() && colombiaConfig.body() != null) {

            ConfigColombiaDTO config = colombiaConfig.body();
            retrofit2.Response<StartHeaderInfoDTO> headerInfo = webApi
                    .getHeaderInfo(config.getApiVersion(), config.getAuthPN(), config.getAuthPT())
                    .execute();

        }

        return null;
    }
}
