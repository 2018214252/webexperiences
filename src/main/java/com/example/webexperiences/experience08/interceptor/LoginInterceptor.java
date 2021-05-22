package com.example.webexperiences.experience08.interceptor;


import com.example.webexperiences.experience08.component.EncryptorComponent;
import com.example.webexperiences.experience08.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptorComponent encryptorComponent;

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handle){
        String token = request.getHeader("token");
        log.debug(token);
        if(token == null){
            throw new MyException(401,"未登录");
        }
        Map<String,Object>result = encryptorComponent.decrypt(token);
        log.debug(token);
        request.setAttribute("userName",result.get("userName"));
        return true;
    }
}
