package com.example.webexperiences.experience04;

import com.example.webexperiences.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Slf4j
@Rollback(value = false)
public class UserMapperTest {
    @Autowired
    private UserMapper01 userMapper;
    @Test
    public void addUser_test(){
        User user = new User();
        user.setId(2018214253L);
        user.setName("XXX");
        user.setCompany("nefu");
        userMapper.insert(user);
    }

    @Test
    public void updateUser_test(){
        User user = new User();
        user.setId(2018214253L);
        user.setName("XIAOMING");
        user.setCompany("nefu");
        userMapper.updateById(user);
    }

    @Test
    public void removeUser_test(){
        User user = new User();
        user.setId(2018214253L);
        user.setName("XIAOMING");
        user.setCompany("nefu");
        userMapper.remove(user);
    }

    @Test
    public void getUser_test(){
        User user = userMapper.get(2018214253L);
        log.debug(user.getName());
        log.debug(user.getCompany());
    }

    @Test
    public void listUser_test(){
        List<User>list = userMapper.list();
        list.forEach(u->log.debug(u.getName()));
    }

}
