package co.anbora.labs.claro.data.remote.api.interceptors;

import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.domain.exceptions.TokenNotFoundException;
import com.jasongoodwin.monads.Try;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

import static co.anbora.labs.claro.domain.constants.AuthConstants.*;

public class AuthorizationInterceptor implements Interceptor {

    private TokenDao tokenDao;

    public AuthorizationInterceptor(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return getTokenLogin()
                .flatMap(loginTokenVO -> getResponse(chain, loginTokenVO))
                .orElseThrow(TokenNotFoundException::new);
    }

    private Optional<LoginTokenVO> getTokenLogin() {
        return Optional.ofNullable(this.tokenDao.findLastToken());
    }

    private Optional<Response> getResponse(Chain chain, LoginTokenVO loginToken) {

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(USER_ID, loginToken.getUserId())
                .addQueryParameter(AUTH_PN, loginToken.getAuthPN())
                .addQueryParameter(AUTH_PT, loginToken.getAuthPT())
                .addQueryParameter(API_VERSION, loginToken.getApiVersion())
                .addQueryParameter(REGION, COLOMBIA)
                .addQueryParameter(HKS, loginToken.getHKS())
                .build();
        // Request customization: add request headers
        Request.Builder builder = original.newBuilder()
                .url(url);
        return Try.ofFailable(
                () -> chain.proceed(builder.build())
        ).toOptional();
    }

}
