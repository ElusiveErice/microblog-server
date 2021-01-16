package com.csu.server.controller;

import com.csu.server.mapper.UserMapper;
import com.csu.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = {"/query"},method=RequestMethod.GET)
    public List<User>find(){
        return userMapper.find();
    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return  "HelloWorld";
    }


}
