package com.zys.redisdemo.controller;

import com.zys.redisdemo.entity.User;
import com.zys.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/9/16 0016
 * @dec 用户接口
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{username}")
    public List<User> getByUsername(@PathVariable("username")String username){
        return userService.getByUsername(username);
    }

    @DeleteMapping("/{username}")
    public void deleteByUsername(@PathVariable("username")String username){
        userService.deleteByUsername(username);
    }

}
