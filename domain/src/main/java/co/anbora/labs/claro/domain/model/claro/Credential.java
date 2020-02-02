package co.anbora.labs.claro.domain.model.claro;

import lombok.Data;

@Data
public class Credential {

    private String userName;
    private String password;

    public Credential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
