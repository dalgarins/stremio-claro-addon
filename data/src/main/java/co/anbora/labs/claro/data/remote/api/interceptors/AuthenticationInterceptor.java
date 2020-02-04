package co.anbora.labs.claro.data.remote.api.interceptors;

import co.anbora.labs.claro.data.remote.api.rest.ClaroAPAWebApi;
import co.anbora.labs.claro.data.remote.api.rest.ClaroColombiaConfigApi;
import co.anbora.labs.claro.data.remote.model.login.ConfigColombiaDTO;
import co.anbora.labs.claro.data.remote.model.login.StartHeaderInfoDTO;
import co.anbora.labs.claro.domain.exceptions.LoginErrorException;
import com.jasongoodwin.monads.Try;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

public class AuthenticationInterceptor implements Interceptor {

    private ClaroColombiaConfigApi claroColombiaConfigApi;
    private ClaroAPAWebApi webApi;

    public AuthenticationInterceptor(ClaroColombiaConfigApi colombiaConfigApi, ClaroAPAWebApi webApi) {
        this.claroColombiaConfigApi = colombiaConfigApi;
        this.webApi = webApi;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        return getColombiaConfig()
                .flatMap(this::getHeaderInfo)
                .flatMap(startHeaderInfoDTO -> getResponse(chain, startHeaderInfoDTO))
                .orElseThrow(LoginErrorException::new);
    }

    private Optional<ConfigColombiaDTO> getColombiaConfig() {
        return Try.ofFailable(
                () -> claroColombiaConfigApi
                .colombia().execute()
        ).filter(retrofit2.Response::isSuccessful)
                .map(retrofit2.Response::body)
                .toOptional();
    }

    private Optional<StartHeaderInfoDTO> getHeaderInfo(ConfigColombiaDTO config) {
        return Try.ofFailable(
                () -> webApi
                .getHeaderInfo(config.getApiVersion(), config.getAuthPN(), config.getAuthPT()).execute()
        ).filter(retrofit2.Response::isSuccessful)
                .map(retrofit2.Response::body)
                .toOptional();
    }

    private Optional<Response> getResponse(Chain chain, StartHeaderInfoDTO headerInfoDTO) {

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("authpn", headerInfoDTO.getEntry().getAuthPN())
                .addQueryParameter("authpt", headerInfoDTO.getEntry().getAuthPT())
                .addQueryParameter("api_version", headerInfoDTO.getEntry().getApiVersion())
                .addQueryParameter("region", "colombia")
                .addQueryParameter("HKS", headerInfoDTO.getHKS())
                .build();
        // Request customization: add request headers
        Request.Builder builder = original.newBuilder()
                .url(url);
        return Try.ofFailable(
                () -> chain.proceed(builder.build())
        ).toOptional();
    }

}
