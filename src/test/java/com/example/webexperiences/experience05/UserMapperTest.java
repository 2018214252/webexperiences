package com.example.webexperiences.experience05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper02 userMapper;

    @Test
    public void test(){
        UserDTO userDTO = userMapper.getByXML2(2L);
        log.debug(userDTO.getName());
        userDTO.getAddresses().forEach(a->{
            log.debug("{}/{}",a.getDetail(),a.getCreateTime());
        });
    }
}
