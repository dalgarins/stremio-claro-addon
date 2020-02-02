package co.anbora.labs.claro.domain.repository;

import co.anbora.labs.claro.domain.model.claro.LoginToken;

public interface IAddOnRepository {

    LoginToken getCurrentToken();

}
