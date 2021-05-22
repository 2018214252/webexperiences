package com.example.webexperiences.experience07.controller;

import com.example.webexperiences.experience07.dto.User;
import com.example.webexperiences.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/experience07/")
public class UserController {
    @GetMapping("/users")
    public ResultVO getUsers(){
        return ResultVO.success(Map.of("users",listUsers()));
    }

    @GetMapping("/users/{uid}")
    public ResultVO GetUser(@PathVariable long uid){
        User user = listUsers().stream()
                .filter(u->u.getId()==uid)
                .findFirst()
                .orElse(null);
        if(user!=null) return ResultVO.success(Map.of("user",user));
        else return ResultVO.error(404,"用户不存在");
    }

    @PostMapping("/users")
    public ResultVO addUser(@RequestBody User user){
        List<User>users = listUsers();
        users.add(user);
        return ResultVO.success(Map.of("users",users));
    }

    public List<User> listUsers(){
        List<User> users = new ArrayList<>();
        User user1 = User.builder().id(1L).name("QYH").password("2018214252").build();
        User user2 = User.builder().id(2L).name("BO").password("123456").build();
        users.add(user1);
        users.add(user2);
        return users;
    }

}
