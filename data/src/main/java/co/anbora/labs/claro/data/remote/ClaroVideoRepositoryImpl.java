package co.anbora.labs.claro.data.remote;

import co.anbora.labs.claro.data.remote.api.rest.ClaroLoginWebApi;
import co.anbora.labs.claro.data.remote.managers.CategoryManager;
import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.domain.exceptions.LoginErrorException;
import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.model.claro.Credential;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import com.jasongoodwin.monads.Try;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ClaroVideoRepositoryImpl implements IClaroVideoRepository {

    private Credential claroCredential;
    private ClaroLoginWebApi claroWebApi;
    private Function<LoginDTO, LoginTokenVO> dbTokenMapper;
    private Function<LoginTokenVO, LoginToken> tokenMapper;
    private TokenDao tokenDao;
    private CategoryManager categoryManager;

    public ClaroVideoRepositoryImpl(Credential claroCredential,
                                    Function<LoginDTO, LoginTokenVO> dbTokenMapper,
                                    Function<LoginTokenVO, LoginToken> tokenMapper,
                                    ClaroLoginWebApi claroWebApi,
                                    TokenDao tokenDao,
                                    CategoryManager categoryManager) {
        this.claroCredential = claroCredential;
        this.dbTokenMapper = dbTokenMapper;
        this.tokenMapper = tokenMapper;
        this.claroWebApi = claroWebApi;
        this.tokenDao = tokenDao;
        this.categoryManager = categoryManager;
    }

    @Override
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

    @Override
    public List<CategoryVideo> movieCategories(String nodeType) {
        return categoryManager.movieCategories(nodeType);
    }


}
