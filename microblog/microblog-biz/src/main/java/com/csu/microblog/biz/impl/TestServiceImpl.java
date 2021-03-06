package com.csu.microblog.biz.impl;


import com.csu.microblog.biz.TestService;
import com.csu.microblog.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String hello() {
        return userMapper.login(1001).getPassword();
    }

    @Override
    public Map<String,String> upload() {
        return null;
    }
}
