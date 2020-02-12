package co.anbora.labs.claro.data.remote;

import co.anbora.labs.claro.data.remote.managers.CategoryManager;
import co.anbora.labs.claro.data.remote.managers.LoginManager;
import co.anbora.labs.claro.data.remote.managers.VideoManager;
import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.model.claro.StreamMedia;
import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;

import java.util.List;

public class ClaroVideoRepositoryImpl implements IClaroVideoRepository {

    private LoginManager loginManager;
    private CategoryManager categoryManager;
    private VideoManager videoManager;

    public ClaroVideoRepositoryImpl(LoginManager loginManager,
                                    CategoryManager categoryManager,
                                    VideoManager videoManager) {
        this.loginManager = loginManager;
        this.categoryManager = categoryManager;
        this.videoManager = videoManager;
    }

    @Override
    public LoginToken login() {
        return loginManager.login();
    }

    @Override
    public List<CategoryVideo> movieCategories(String nodeType) {
        return categoryManager.movieCategories(nodeType);
    }

    @Override
    public List<Video> videos() {
        return videoManager.videos();
    }

    @Override
    public StreamMedia streamMedia(String videoId) {
        return videoManager.streamMediaById(videoId);
    }


}
