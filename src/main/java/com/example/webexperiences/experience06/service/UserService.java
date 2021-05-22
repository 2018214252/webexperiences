package com.example.webexperiences.experience06.service;

import com.example.webexperiences.experience06.aspect.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@MyInterceptor
public class UserService {
    public void buyCar(){
        log.debug("buyCar");
    }

    @MyInterceptor(value = MyInterceptor.MyAuthorityType.ADMIN)
    public void addUser(){
        //log.debug("管理员权限");
    }
    public void getUser(){
        //log.debug("普通用户权限");
    }
}
