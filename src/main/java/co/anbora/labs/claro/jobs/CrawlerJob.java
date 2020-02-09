package co.anbora.labs.claro.jobs;

import co.anbora.labs.claro.domain.usecase.UseCaseExecutor;
import co.anbora.labs.claro.domain.usecase.videos.SyncRemoteVideosUseCase;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.function.Function;

@Singleton
public class CrawlerJob {

    @Inject
    UseCaseExecutor useCaseExecutor;
    @Inject
    SyncRemoteVideosUseCase syncRemoteVideosUseCase;

    @Scheduled(initialDelay = "1m", fixedRate = "5m")
    public void process() {
        useCaseExecutor.execute(syncRemoteVideosUseCase,
                new SyncRemoteVideosUseCase.Request(),
                Function.identity()
        );
    }
}