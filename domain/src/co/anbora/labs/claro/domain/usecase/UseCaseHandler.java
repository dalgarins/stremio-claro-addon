package co.anbora.labs.claro.domain.usecase;

import java.util.concurrent.CompletableFuture;

public class UseCaseHandler {

    private UseCaseScheduler mUseCaseScheduler;

    public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        mUseCaseScheduler = useCaseScheduler;
    }

    public <Request extends UseCase.RequestValues, Response extends UseCase.ResponseValue>
            CompletableFuture<Response> execute(UseCase<Request, Response> useCase, Request values) {
        useCase.setRequestValues(values);
        return mUseCaseScheduler.execute(useCase::run);
    }

}
