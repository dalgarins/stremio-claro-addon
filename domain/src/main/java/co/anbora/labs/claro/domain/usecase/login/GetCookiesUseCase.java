package co.anbora.labs.claro.domain.usecase.login;


import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

public class GetCookiesUseCase extends UseCase<GetCookiesUseCase.Request, GetCookiesUseCase.Response> {

    private IClaroVideoRepository claroVideoRepository;

    public GetCookiesUseCase(IClaroVideoRepository claroVideoRepository) {
        this.claroVideoRepository = claroVideoRepository;
    }

    @Override
    public Response execute(Request input) {
        return null;
    }


    @Value
    public static class Request implements UseCase.InputValues {

    }

    @Value
    public static class Response implements UseCase.OutputValues {

    }

}
