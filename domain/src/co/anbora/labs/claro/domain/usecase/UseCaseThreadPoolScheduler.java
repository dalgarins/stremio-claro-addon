package co.anbora.labs.claro.domain.usecase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class UseCaseThreadPoolScheduler implements UseCaseScheduler {

    private Executor executor;

    public UseCaseThreadPoolScheduler() {
        executor = Executors.newCachedThreadPool();
    }

    @Override
    public <Response extends UseCase.ResponseValue> CompletableFuture<Response> execute(Supplier<Response> supplier) {
        return CompletableFuture.supplyAsync(supplier, executor);
    }
}
