package co.anbora.labs.claro.data.remote.mapper;

import co.anbora.labs.claro.data.remote.model.CategoryVideoDTO;
import co.anbora.labs.claro.data.remote.model.category.CategoryDTO;
import co.anbora.labs.claro.data.remote.model.category.ComponentsDTO;
import co.anbora.labs.claro.data.remote.model.category.ModulesDTO;
import co.anbora.labs.claro.data.remote.model.category.PropertyDTO;
import co.anbora.labs.claro.data.remote.model.responses.ResponseCategoryDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoryDTOtoListMapper implements Function<CategoryDTO, List<CategoryVideoDTO>> {

    @Override
    public List<CategoryVideoDTO> apply(CategoryDTO categoryDTO) {
        List<CategoryVideoDTO> categories = new ArrayList<>();
        if (Objects.nonNull(categoryDTO)) {
            categories = getPropertiesFromCategory(categoryDTO)
                    .stream()
                    .filter(PropertyDTO::hasValidUrl)
                    .map(this::transform)
                    .collect(Collectors.toList());;
        }
        return categories;
    }

    private List<PropertyDTO> getPropertiesFromCategory(CategoryDTO categoryDTO) {
        return Stream.of(categoryDTO)
                .map(CategoryDTO::getResponse)
                .map(ResponseCategoryDTO::getModule)
                .map(ModulesDTO::getModules)
                .flatMap(Collection::stream)
                .map(ModulesDTO.ModuleDTO::getComponents)
                .map(ComponentsDTO::getComponents)
                .flatMap(Collection::stream)
                .map(ComponentsDTO.ComponentDTO::getProperty)
                .collect(Collectors.toList());
    }

    private CategoryVideoDTO transform(PropertyDTO propertyDTO) {
        return new CategoryVideoDTO(propertyDTO.getId(), propertyDTO.getUrl());
    }
}
