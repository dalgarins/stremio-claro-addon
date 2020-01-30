package co.anbora.labs.claro.data.remote;

import co.anbora.labs.claro.data.remote.api.rest.ClaroMFWKWebApi;
import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.domain.exceptions.LoginErrorException;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import com.jasongoodwin.monads.Try;
import retrofit2.Response;

import java.util.Optional;
import java.util.function.Function;

public class ClaroVideoRepositoryImpl implements IClaroVideoRepository {

    private ClaroMFWKWebApi claroWebApi;
    private Function<LoginDTO, LoginToken> tokenMapper;

    public ClaroVideoRepositoryImpl(Function<LoginDTO, LoginToken> tokenMapper,
                                    ClaroMFWKWebApi claroWebApi) {
        this.tokenMapper = tokenMapper;
        this.claroWebApi = claroWebApi;
    }

    @Override
    public LoginToken login() {
        return this.tokenMapper.apply(
                loginUser().orElseThrow(LoginErrorException::new)
        );
    }

    private Optional<LoginDTO> loginUser() {
        return Try.ofFailable(
                () -> this.claroWebApi.login("", "").execute()
        ).map(Response::body).toOptional();
    }

}
