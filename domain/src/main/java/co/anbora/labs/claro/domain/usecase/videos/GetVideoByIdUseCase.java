package co.anbora.labs.claro.domain.usecase.videos;

import co.anbora.labs.claro.domain.model.claro.Video;
import co.anbora.labs.claro.domain.repository.IAddOnRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

public class GetVideoByIdUseCase extends UseCase<GetVideoByIdUseCase.Request, GetVideoByIdUseCase.Response> {

    private IAddOnRepository repository;

    public GetVideoByIdUseCase(IAddOnRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        return new Response(repository.getVideoById(input.videoId));
    }

    @Value
    public static class Request implements UseCase.InputValues {
        private String videoId;
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private Video video;
    }
}
