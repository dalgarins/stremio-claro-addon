package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.CategoryVideoDTO;
import co.anbora.labs.claro.data.repository.model.CategoryVO;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static co.anbora.labs.claro.domain.constants.CategoryConstants.*;
import static co.anbora.labs.claro.domain.constants.Constants.*;

public class CategoryVideoDTOtoVOMapper implements Function<CategoryVideoDTO, CategoryVO> {

    @Override
    public CategoryVO apply(CategoryVideoDTO categoryVideoDTO) {
        if (Objects.isNull(categoryVideoDTO)) {
            return null;
        }
        return transform(categoryVideoDTO);
    }

    private CategoryVO transform(CategoryVideoDTO categoryVideoDTO) {
        Map<String, String> fields = Arrays.stream(categoryVideoDTO.getFormattedUrl().split(AND_CHARACTER))
                .map(str -> str.split(EQUAL_CHARACTER))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
        return new CategoryVO(
                fields.getOrDefault(FILTER_ID, EMPTY_VALUE),
                fields.getOrDefault(FROM, EMPTY_VALUE),
                fields.getOrDefault(QUANTITY, EMPTY_VALUE),
                fields.getOrDefault(LEVEL_ID, EMPTY_VALUE),
                fields.getOrDefault(ORDER_WAY, EMPTY_VALUE),
                fields.getOrDefault(ORDER_ID, EMPTY_VALUE),
                fields.getOrDefault(REGION, EMPTY_VALUE)
        );
    }

}
