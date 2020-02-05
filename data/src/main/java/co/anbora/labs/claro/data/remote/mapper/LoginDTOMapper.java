package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.login.LoginDTO;
import co.anbora.labs.claro.data.repository.model.LoginTokenVO;

import java.util.function.Function;

public class LoginDTOMapper implements Function<LoginDTO, LoginTokenVO> {
    @Override
    public LoginTokenVO apply(LoginDTO loginDTO) {
        if (loginDTO == null) {
            return null;
        }
        return new LoginTokenVO(loginDTO.getResponse().getUserId(),
                loginDTO.getResponse().getUserName(),
                loginDTO.getResponse().getUserToken(),
                loginDTO.getResponse().getUserSession(),
                loginDTO.getEntry().getAuthPN(),
                loginDTO.getEntry().getAuthPT(),
                loginDTO.getEntry().getHKS(),
                loginDTO.getEntry().getApiVersion());
    }
}
