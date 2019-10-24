package com.dream.demo.controller;

import com.dream.demo.entity.User;
import com.dream.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/")
    public String goUser(){
        return "index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public List<User> getUser(){
        return userService.getAll(null);
    }
}
