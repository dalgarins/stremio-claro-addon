package co.anbora.labs.claro.domain.usecase.videos;

import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class SyncRemoteVideosUseCase extends UseCase<SyncRemoteVideosUseCase.Request, SyncRemoteVideosUseCase.Response> {

    private IClaroVideoRepository repository;

    public SyncRemoteVideosUseCase(IClaroVideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        return new Response(this.repository.videos());
    }

    @Value
    public static class Request implements UseCase.InputValues {
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private List<Video> categoryVideos;
    }
}
