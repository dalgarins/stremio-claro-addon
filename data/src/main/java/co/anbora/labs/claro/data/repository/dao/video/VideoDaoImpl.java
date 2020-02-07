package co.anbora.labs.claro.data.repository.dao.video;

import co.anbora.labs.claro.data.repository.model.VideoVO;
import co.anbora.labs.claro.domain.model.claro.Video;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class VideoDaoImpl implements VideoDao {

    private SqlSessionFactory sqlSessionFactory;

    public VideoDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(VideoVO video) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            getVideoDao(session).insert(video);
            session.commit();
        }
    }

    @Override
    public void insert(List<VideoVO> videos) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoDao videoDao = getVideoDao(session);
            videos.forEach(videoDao::insert);
            session.commit();
            session.clearCache();
        }
    }

    @Override
    public Video findById(String id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getVideoDao(session).findById(id);
        }
    }

    @Override
    public List<VideoVO> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return getVideoDao(session).findAll();
        }
    }

    private VideoDao getVideoDao(SqlSession session) {
        return session.getMapper(VideoDao.class);
    }
}
