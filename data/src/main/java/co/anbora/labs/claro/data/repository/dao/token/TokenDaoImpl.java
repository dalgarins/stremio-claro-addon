package co.anbora.labs.claro.data.repository.dao.token;

import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TokenDaoImpl implements TokenDao {

    private SqlSessionFactory sqlSessionFactory;

    public TokenDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(LoginTokenVO tokenVO) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            getTokenDao(session).insert(tokenVO);
            session.commit();
        }
    }

    @Override
    public LoginTokenVO findLastToken() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getTokenDao(session).findLastToken();
        }
    }

    private TokenDao getTokenDao(SqlSession sqlSession) {
        return sqlSession.getMapper(TokenDao.class);
    }

}
