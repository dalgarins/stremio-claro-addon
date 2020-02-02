package co.anbora.labs.claro.data.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class LoginTokenVO {

    private String id;
    private String userId;
    private String userName;
    private String userToken;
    private String userSession;
    private String authPN;
    private String authPT;
    private String HKS;
    private String apiVersion;
    private Boolean active;

    public LoginTokenVO(String userId, String userName, String userToken, String userSession, String authPN, String authPT, String HKS, String apiVersion) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.userName = userName;
        this.userToken = userToken;
        this.userSession = userSession;
        this.authPN = authPN;
        this.authPT = authPT;
        this.HKS = HKS;
        this.apiVersion = apiVersion;
        this.active = true;
    }
}
