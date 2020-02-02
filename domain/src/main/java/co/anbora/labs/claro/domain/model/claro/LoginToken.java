package co.anbora.labs.claro.domain.model.claro;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginToken {

    private String userId;
    private String userName;
    private String userToken;
    private String userSession;
    private String authPN;
    private String authPT;
    private String HKS;
    private String apiVersion;

}
