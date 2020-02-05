package co.anbora.labs.claro.domain.usecase.category;

import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import co.anbora.labs.claro.domain.repository.IClaroVideoRepository;
import co.anbora.labs.claro.domain.usecase.UseCase;
import lombok.Value;

import java.util.List;

public class GetCategoriesUseCase extends UseCase<GetCategoriesUseCase.Request, GetCategoriesUseCase.Response> {

    private IClaroVideoRepository claroVideoRepository;

    public GetCategoriesUseCase(IClaroVideoRepository claroVideoRepository) {
        this.claroVideoRepository = claroVideoRepository;
    }

    @Override
    public Response execute(Request input) {        ;
        return new Response(this.claroVideoRepository.movieCategories(input.nodeInfo));
    }

    @Value
    public static class Request implements UseCase.InputValues {
        private String nodeInfo;
    }

    @Value
    public static class Response implements UseCase.OutputValues {
        private List<CategoryVideo> categoryVideos;
    }
}
