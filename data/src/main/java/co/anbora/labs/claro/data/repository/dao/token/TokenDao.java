package co.anbora.labs.claro.data.repository.dao.token;

import co.anbora.labs.claro.data.repository.model.LoginTokenVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TokenDao {

    @Insert("insert into login_token "
            + "values(#{token.id}, #{token.userId}, #{token.userName}, #{token.userToken}, "
            + "#{token.userSession}, #{token.authPN}, #{token.authPT}, "
            + "#{token.HKS}, #{token.apiVersion}, #{token.active})")
    void insert(@Param("token") LoginTokenVO tokenVO);

    @Select("select * from login_token where active=true limit 1")
    LoginTokenVO findLastToken();

}
