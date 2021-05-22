package com.example.webexperiences.experience08.controller;

import com.example.webexperiences.experience08.component.EncryptorComponent;
import com.example.webexperiences.experience08.dto.User;
import com.example.webexperiences.experience08.exception.MyException;
import com.example.webexperiences.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/experience08/")
@Slf4j
public class LoginController {
    @Autowired
    private EncryptorComponent encryptor;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String,Object> mp = new HashMap();

    @PostMapping("/register")
    public ResultVO register(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        mp.put(user.getUserName(),user);
        return ResultVO.success(mp);
    }

    @PostMapping("/login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User u =(User) mp.get(user.getUserName());
        if(u==null||!passwordEncoder.matches(user.getPassword(),u.getPassword())){
            return ResultVO.error(401,"用户名密码错误");
        }
        String result = encryptor.encrypt(Map.of("userName",user.getUserName()));
        log.debug(result);
        response.addHeader("token",result);
        return ResultVO.success(Map.of());
    }

    @GetMapping("/index")
    public ResultVO getIndex(@RequestAttribute("userName") String userName){

        return ResultVO.success(Map.of("userName",userName));
    }

}
