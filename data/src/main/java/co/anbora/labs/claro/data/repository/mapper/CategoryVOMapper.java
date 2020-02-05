package co.anbora.labs.claro.data.repository.mapper;

import co.anbora.labs.claro.data.repository.model.CategoryVO;
import co.anbora.labs.claro.domain.model.claro.CategoryVideo;

import java.util.Objects;
import java.util.function.Function;

public class CategoryVOMapper implements Function<CategoryVO, CategoryVideo> {
    @Override
    public CategoryVideo apply(CategoryVO categoryVO) {
        if (Objects.isNull(categoryVO)) {
            return null;
        }
        return CategoryVideo.builder()
                .filterId(categoryVO.getFilterId())
                .from(categoryVO.getFrom())
                .levelId(categoryVO.getLevelId())
                .orderId(categoryVO.getOrderId())
                .orderWay(categoryVO.getOrderWay())
                .quantity(categoryVO.getQuantity())
                .region(categoryVO.getRegion())
                .build();
    }
}
