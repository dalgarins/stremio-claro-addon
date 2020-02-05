package co.anbora.labs.claro.data.remote.managers;

import co.anbora.labs.claro.data.remote.api.rest.ClaroLoginWebApi;
import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.domain.exceptions.LoginErrorException;
import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import com.jasongoodwin.monads.Try;
import retrofit2.Response;

import java.util.Optional;
import java.util.function.Function;

public class LoginManager {

    private Credential claroCredential;
    private ClaroLoginWebApi claroWebApi;
    private Function<LoginDTO, LoginTokenVO> dbTokenMapper;
    private Function<LoginTokenVO, LoginToken> tokenMapper;
    private TokenDao tokenDao;

    public LoginManager(Credential claroCredential,
                        Function<LoginDTO, LoginTokenVO> dbTokenMapper,
                        Function<LoginTokenVO, LoginToken> tokenMapper,
                        ClaroLoginWebApi claroWebApi,
                        TokenDao tokenDao) {
        this.claroCredential = claroCredential;
        this.dbTokenMapper = dbTokenMapper;
        this.tokenMapper = tokenMapper;
        this.claroWebApi = claroWebApi;
        this.tokenDao = tokenDao;
    }

    public LoginToken login() {
        LoginTokenVO tokenVO = this.dbTokenMapper.apply(
                loginUser().orElseThrow(LoginErrorException::new)
        );
        tokenDao.insert(tokenVO);
        return this.tokenMapper.apply(tokenVO);
    }

    private Optional<LoginDTO> loginUser() {
        return Try.ofFailable(
                () -> this.claroWebApi.login(claroCredential.getUserName(), claroCredential.getPassword()).execute()
        ).map(Response::body).toOptional();
    }

}
