package co.anbora.labs.claro.domain.usecase.stremio;

import co.anbora.labs.claro.domain.model.stremio.Stream;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import static co.anbora.labs.claro.domain.constants.StremioConstants.StremioCatalog.MOVIE;

public class GetStreamByIdUseCase extends UseCase<GetStreamByIdUseCase.Request, GetStreamByIdUseCase.Response> {

    @Override
    public Response execute(Request input) {
        if (MOVIE.equals(input.type)) {

        }
        return new Response(null);
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
