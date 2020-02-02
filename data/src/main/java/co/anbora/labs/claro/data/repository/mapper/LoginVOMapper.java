package co.anbora.labs.claro.data.repository.mapper;

import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import co.anbora.labs.claro.domain.model.claro.LoginToken;

import java.util.function.Function;

public class LoginVOMapper implements Function<LoginTokenVO, LoginToken> {
    @Override
    public LoginToken apply(LoginTokenVO loginTokenVO) {
        if (loginTokenVO == null) {
            return null;
        }
        return LoginToken.builder()
                .userId(loginTokenVO.getUserId())
                .userName(loginTokenVO.getUserName())
                .userToken(loginTokenVO.getUserToken())
                .userSession(loginTokenVO.getUserSession())
                .authPN(loginTokenVO.getAuthPN())
                .authPT(loginTokenVO.getAuthPT())
                .apiVersion(loginTokenVO.getApiVersion())
                .HKS(loginTokenVO.getHKS())
                .build();
    }
}
