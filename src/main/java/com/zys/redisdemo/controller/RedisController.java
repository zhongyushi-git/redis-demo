package com.zys.redisdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RedisController {

    @GetMapping("/save")
    public String save(String name, HttpSession session) {
        //向session中存储数据
        session.setAttribute("name", name);
        return name;
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        //从session中h获取数据
        return "session中的数据" + session.getAttribute("name");
    }
}
