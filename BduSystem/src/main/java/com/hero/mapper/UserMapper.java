package com.hero.mapper;

import com.hero.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Heroxin
 * @create 2022-03-31-16:24
 * @Description:
 */
public interface UserMapper {
//    用户登录
    @Select("select * from user where email = #{email} and username = #{username} and password = #{password}")
    User query(User user);

//    添加用户
    @Insert("insert into user values(#{email},#{username},#{password});")
    void insert(User user);
}
