package com.example.webexperiences.experience06;

import com.example.webexperiences.experience06.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AspectTest {
    @Autowired
    private UserService userService;

    @Test
    public void Test1(){
        userService.buyCar();
    }

    @Test
    public void Test2(){
        userService.addUser();;
        userService.getUser();
    }
}
