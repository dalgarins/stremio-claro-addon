package co.anbora.labs.claro.data.repository.dao.token;

import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TokenDao {

    @Insert("merge into login_token key (user_id) "
            + "values(#{token.userId}, #{token.userName}, #{token.userToken}, "
            + "#{token.userSession}, #{token.authPN}, #{token.authPT}, "
            + "#{token.HKS}, #{token.apiVersion})")
    void insert(@Param("token") LoginTokenVO tokenVO);

    @Select("select * from login_token limit 1")
    LoginTokenVO findLastToken();

}
