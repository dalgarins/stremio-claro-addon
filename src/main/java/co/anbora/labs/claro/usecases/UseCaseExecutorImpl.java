package co.anbora.labs.claro.usecases;

import co.anbora.labs.claro.domain.usecase.UseCase;
import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;

import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Singleton
public class UseCaseExecutorImpl implements UseCaseExecutor {
    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(
            UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {
        return CompletableFuture
                .supplyAsync(() -> input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
    }
}
