package co.anbora.labs.claro.data.repository.dao.category;

import co.anbora.labs.claro.data.repository.model.CategoryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {

    @Insert("merge into categories key (filter_id) "
            + "values(#{category.filterId}, #{category.from}, #{category.quantity}, "
            + "#{category.levelId}, #{category.orderWay}, #{category.orderId}, "
            + "#{category.region})")
    void insert(@Param("category") CategoryVO categoryVO);

    void insert(List<CategoryVO> categories);

    @Select("select * from categories")
    List<CategoryVO> findAll();

}
