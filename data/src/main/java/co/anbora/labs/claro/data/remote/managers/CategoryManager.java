package co.anbora.labs.claro.data.remote.managers;

import co.anbora.labs.claro.data.remote.api.rest.ClaroVideoApi;
import co.anbora.labs.claro.data.remote.model.CategoryVideoDTO;
import co.anbora.labs.claro.data.remote.model.category.CategoryDTO;
import co.anbora.labs.claro.data.repository.dao.category.CategoryDao;
import co.anbora.labs.claro.data.repository.model.CategoryVO;
import co.anbora.labs.claro.domain.exceptions.CategoryNotFoundException;
import co.anbora.labs.claro.domain.model.claro.CategoryVideo;
import com.jasongoodwin.monads.Try;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CategoryManager {

    private Function<CategoryDTO, List<CategoryVideoDTO>> categoryDTOListMapper;
    private Function<List<CategoryVideoDTO>, List<CategoryVO>> listCategoryVOMapper;
    private Function<List<CategoryVO>, List<CategoryVideo>> listCategoryMapper;
    private ClaroVideoApi claroVideoApi;
    private CategoryDao categoryDao;

    public CategoryManager(Function<CategoryDTO, List<CategoryVideoDTO>> categoryDTOListMapper,
                           Function<List<CategoryVideoDTO>, List<CategoryVO>> listCategoryVOMapper,
                           Function<List<CategoryVO>, List<CategoryVideo>> listCategoryMapper,
                           ClaroVideoApi claroVideoApi, CategoryDao categoryDao) {
        this.categoryDTOListMapper = categoryDTOListMapper;
        this.listCategoryVOMapper = listCategoryVOMapper;
        this.claroVideoApi = claroVideoApi;
        this.categoryDao = categoryDao;
        this.listCategoryMapper = listCategoryMapper;
    }

    public List<CategoryVideo> movieCategories(String nodeType) {
        List<CategoryVO> categoriesVO = getCategoriesByNode(nodeType)
                .map(categoryDTOListMapper)
                .map(listCategoryVOMapper)
                .orElseThrow(CategoryNotFoundException::new)
                .stream()
                .filter(CategoryVO::hasValidFilterId)
                .collect(Collectors.toList());
        this.categoryDao.insert(categoriesVO);
        return listCategoryMapper.apply(categoriesVO);
    }

    private Optional<CategoryDTO> getCategoriesByNode(String nodeType) {
        return Try.ofFailable(
                () -> this.claroVideoApi.categories(nodeType).execute()
        ).map(Response::body).toOptional();
    }

}
