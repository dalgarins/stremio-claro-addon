package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.CategoryVideoDTO;
import co.anbora.labs.claro.data.repository.model.CategoryVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListCategoryVideoDTOtoVOMapper implements Function<List<CategoryVideoDTO>, List<CategoryVO>> {

    private Function<CategoryVideoDTO, CategoryVO> categoryMapper;

    public ListCategoryVideoDTOtoVOMapper(Function<CategoryVideoDTO, CategoryVO> categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryVO> apply(List<CategoryVideoDTO> categoryVideoDTOS) {
        List<CategoryVO> categories = new ArrayList<>();
        if (Objects.nonNull(categoryVideoDTOS)) {
            categories = categoryVideoDTOS
                    .stream()
                    .map(categoryMapper)
                    .collect(Collectors.toList());
        }
        return categories;
    }
}
