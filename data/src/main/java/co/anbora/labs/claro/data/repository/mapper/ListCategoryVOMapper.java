package co.anbora.labs.claro.data.repository.mapper;

import co.anbora.labs.claro.data.repository.model.CategoryVO;
import co.anbora.labs.claro.domain.model.claro.CategoryVideo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListCategoryVOMapper implements Function<List<CategoryVO>, List<CategoryVideo>> {

    private Function<CategoryVO, CategoryVideo> mapper;

    public ListCategoryVOMapper(Function<CategoryVO, CategoryVideo> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<CategoryVideo> apply(List<CategoryVO> categoryVOS) {
        List<CategoryVideo> categories = new ArrayList<>();
        if (Objects.nonNull(categoryVOS)) {
            categories = categoryVOS.stream()
                    .map(mapper)
                    .collect(Collectors.toList());
        }
        return categories;
    }
}
