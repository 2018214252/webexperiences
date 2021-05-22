package com.example.webexperiences.experience04;

import com.example.webexperiences.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper01 {
    @Insert("insert into user(id, name, company) values(#{id}, #{name}, #{company})")
    public void insert(User user);

    @Update("update user set name = #{name}, company = #{company} where id = #{id}")
    public void updateById(User user);

    @Delete("delete from user where id = #{id}")
    public void remove(User user);

    @Select("select * from user u where u.id = #{uid}")
    User get(@Param("uid") long uid);

    @Select("select * from user")
    List<User> list();
}
