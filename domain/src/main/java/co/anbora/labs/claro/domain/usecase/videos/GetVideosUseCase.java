package co.anbora.labs.claro.domain.usecase.videos;

import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class GetVideosUseCase extends UseCase<GetVideosUseCase.Request, GetVideosUseCase.Response>{

    private IAddOnRepository repository;

    public GetVideosUseCase(IAddOnRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        return new Response(this.repository.getAllVideos());
    }

    @Value
    public static class Request implements UseCase.InputValues {

    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private List<Video> videos;
    }
}
