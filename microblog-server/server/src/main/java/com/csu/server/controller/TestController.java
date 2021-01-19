package com.csu.server.controller;

import com.csu.server.mapper.UserMapper;
import com.csu.server.model.LoginData;
import com.csu.server.model.LoginUser;
import com.csu.server.model.Response;
import com.csu.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = {"/query"},method=RequestMethod.POST)
    public List<User>find(){
        return userMapper.find();
    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return  "HelloWorld";
    }

}
