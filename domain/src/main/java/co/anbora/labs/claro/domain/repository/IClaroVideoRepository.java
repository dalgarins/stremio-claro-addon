package co.anbora.labs.claro.domain.repository;

import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.model.claro.LoginToken;

import java.util.List;

public interface IClaroVideoRepository {

    LoginToken login();

    List<CategoryVideo> movieCategories(String nodeType);

}
