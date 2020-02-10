package co.anbora.labs.claro.data.repository.dao.video;

import co.anbora.labs.claro.data.repository.model.VideoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoDao {

    @Insert("merge into videos key (video_id) "
            + "values(#{video.id}, #{video.title}, #{video.originalTitle}, "
            + "#{video.description}, #{video.urlImageMedium}, #{video.urlImageLarge}, "
            + "#{video.duration}, #{video.released}, #{video.year})")
    void insert(@Param("video") VideoVO video);

    void insert(List<VideoVO> videos);

    @Select("select * from videos where video_id = #{videoId}")
    VideoVO findById(@Param("videoId") String id);

    @Select("select * from videos ")
    List<VideoVO> findAll();

}
