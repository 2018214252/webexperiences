package com.example.webexperiences.experience05;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webexperiences.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper02 extends BaseMapper<User> {
    UserDTO getByXML2(long uid);
}
