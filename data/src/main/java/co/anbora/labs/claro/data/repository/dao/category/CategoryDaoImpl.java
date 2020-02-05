package co.anbora.labs.claro.data.repository.dao.category;

import co.anbora.labs.claro.data.repository.model.CategoryVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private SqlSessionFactory sqlSessionFactory;

    public CategoryDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(CategoryVO categoryVO) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            getTokenDao(session).insert(categoryVO);
            session.commit();
        }
    }

    @Override
    public void insert(List<CategoryVO> categories) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CategoryDao categoryDao = getTokenDao(session);
            categories.forEach(categoryDao::insert);
            session.commit();
            session.clearCache();
        }
    }

    @Override
    public List<CategoryVO> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getTokenDao(session).findAll();
        }
    }

    private CategoryDao getTokenDao(SqlSession sqlSession) {
        return sqlSession.getMapper(CategoryDao.class);
    }
}
