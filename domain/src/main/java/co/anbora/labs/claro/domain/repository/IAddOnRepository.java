package co.anbora.labs.claro.domain.repository;

import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.Video;

import java.util.List;

public interface IAddOnRepository {

    LoginToken getCurrentToken();

    Video getVideoById(String id);

    List<Video> getAllVideos();
}
