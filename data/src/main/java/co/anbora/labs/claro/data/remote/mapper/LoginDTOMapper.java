package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.domain.model.claro.LoginToken;

import java.util.function.Function;

public class LoginDTOMapper implements Function<LoginDTO, LoginToken> {
    @Override
    public LoginToken apply(LoginDTO loginDTO) {
        if (loginDTO == null) {
            return null;
        }
        return LoginToken.builder()
                .userId(loginDTO.getResponse().getUserId())
                .userName(loginDTO.getResponse().getUserName())
                .userToken(loginDTO.getResponse().getUserToken())
                .userSession(loginDTO.getResponse().getUserSession())
                .authPN(loginDTO.getEntry().getAuthPN())
                .authPT(loginDTO.getEntry().getAuthPT())
                .apiVersion(loginDTO.getEntry().getApiVersion())
                .HKS(loginDTO.getEntry().getHKS())
                .build();
    }
}
