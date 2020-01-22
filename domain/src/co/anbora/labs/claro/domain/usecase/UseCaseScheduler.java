package co.anbora.labs.claro.domain.usecase;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public interface UseCaseScheduler {

    <Response extends UseCase.ResponseValue> CompletableFuture<Response>
                execute(Supplier<Response> supplier);

}
