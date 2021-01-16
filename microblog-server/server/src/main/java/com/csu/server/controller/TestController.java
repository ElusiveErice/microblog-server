package com.csu.server.controller;

import com.csu.server.mapper.UserMapper;
import com.csu.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired(required = false)

    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public List<User> queryalluser(){
        List<User>list = userMapper.query();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return  "HelloWorld";
    }


}
