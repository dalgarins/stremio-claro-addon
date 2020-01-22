package co.anbora.labs.claro.domain.usecase.login;

import co.anbora.labs.claro.domain.model.claro.LoginToken;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;

public class GetCookiesUseCase extends UseCase<GetCookiesUseCase.Request, GetCookiesUseCase.Response> {

    private IClaroVideoRepository claroVideoRepository;

    public GetCookiesUseCase(IClaroVideoRepository claroVideoRepository) {
        this.claroVideoRepository = claroVideoRepository;
    }

    @Override
    protected Response executeUseCase(Request requestValues) {
        return new Response(this.claroVideoRepository.login());
    }

    class Request implements UseCase.RequestValues {

    }

    class Response implements UseCase.ResponseValue {

        private LoginToken loginToken;

        public Response(LoginToken loginToken) {
            this.loginToken = loginToken;
        }

        public LoginToken getLoginToken() {
            return loginToken;
        }
    }

}
