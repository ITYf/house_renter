package top.ityf.dao;

import org.apache.ibatis.annotations.Param;
import top.ityf.domain.User;
import top.ityf.domain.UserExample;

import java.util.List;

public interface UserDao {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteById(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    User selectByUser(User user);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByIdSelective(User record);

    int updateById(User record);

}