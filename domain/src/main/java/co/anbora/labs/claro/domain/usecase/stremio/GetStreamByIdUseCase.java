package co.anbora.labs.claro.domain.usecase.stremio;

import co.anbora.labs.claro.domain.model.claro.StreamMedia;
import co.anbora.labs.claro.domain.model.stremio.Stream;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.MOVIE;

public class GetStreamByIdUseCase extends UseCase<GetStreamByIdUseCase.Request, GetStreamByIdUseCase.Response> {

    private IClaroVideoRepository repository;

    public GetStreamByIdUseCase(IClaroVideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        if (MOVIE.equals(input.type)) {
            return new Response(
                    getStreamVideo(this.repository.streamMedia(input.id))
            );
        }
        return new Response(new Stream());
    }

    private Stream getStreamVideo(StreamMedia media) {
        Stream stream = new Stream();
        stream.addStream(media.getUrlVideo());
        return stream;
    }

    @Value
    public static class Request implements UseCase.InputValues {
        private String type;
        private String id;
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private Stream stream;
    }
}
