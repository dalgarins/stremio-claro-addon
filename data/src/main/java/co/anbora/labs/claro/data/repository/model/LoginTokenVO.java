package co.anbora.labs.claro.data.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginTokenVO {

    private String userId;
    private String userName;
    private String userToken;
    private String userSession;
    private String authPN;
    private String authPT;
    private String HKS;
    private String apiVersion;

}
