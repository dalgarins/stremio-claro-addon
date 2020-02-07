package co.anbora.labs.claro.data.repository;

import co.anbora.labs.claro.data.repository.dao.token.TokenDao;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;

import java.util.List;
import java.util.function.Function;

public class AddOnRepositoryImpl implements IAddOnRepository {

    private TokenDao localTokenDao;
    private Function<LoginTokenVO, LoginToken> loginTokenVOMapper;

    public AddOnRepositoryImpl(TokenDao localTokenDao,
                               Function<LoginTokenVO, LoginToken> loginTokenVOMapper) {
        this.localTokenDao = localTokenDao;
        this.loginTokenVOMapper = loginTokenVOMapper;
    }

    @Override
    public LoginToken getCurrentToken() {
        return loginTokenVOMapper.apply(
                localTokenDao.findLastToken()
        );
    }

    @Override
    public Video getVideoById(String id) {
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return null;
    }
}
