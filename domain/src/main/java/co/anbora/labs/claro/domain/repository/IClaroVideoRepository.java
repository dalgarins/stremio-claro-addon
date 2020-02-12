package co.anbora.labs.claro.domain.repository;

import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.StreamMedia;
import co.anbora.labs.claro.domain.model.claro.Video;

import java.util.List;

public interface IClaroVideoRepository {

    LoginToken login();

    List<CategoryVideo> movieCategories(String nodeType);

    List<Video> videos();

    StreamMedia streamMedia(String videoId);

}
