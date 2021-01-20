package com.csu.microblog.biz.impl;

import com.csu.microblog.biz.UserService;
import com.csu.microblog.biz.model.LoginInfo;
import com.csu.microblog.biz.model.LoginResult;
import com.csu.microblog.biz.model.RegisterInfo;
import com.csu.microblog.biz.model.RegisterResult;
import com.csu.microblog.dao.entity.UserDo;
import com.csu.microblog.dao.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserMapper userMapper;

    @Override
    public LoginResult login(LoginInfo loginInfo) {
        LoginResult loginResult = new LoginResult();

        long account = loginInfo.getAccount();
        UserDo userDo = userMapper.login(account);

        if(userDo==null){
            loginResult.setLogin(false);
            loginResult.setMessage("账号不存在");
        }else if(userDo.getPassword().equals(loginInfo.getPassword())){
            loginResult.setLogin(true);
            loginResult.setMessage("登录成功");
            loginResult.setAccount(account);
            loginResult.setUserName(userDo.getUserName());
        }else{
            loginResult.setLogin(false);
            loginResult.setMessage("密码不正确");
        }

        return loginResult;
    }

    @Override
    public RegisterResult register(RegisterInfo registerInfo) {

        //根据信息去新增一个用户信息
        UserDo userDo = new UserDo();
        userDo.setUserName(registerInfo.getUserName());
        userDo.setPassword(registerInfo.getPassword());
        userDo.setSex(registerInfo.getSex());
        userDo.setPortrait(registerInfo.getPortrait());
        userMapper.register(userDo);

        //根据插入的结果返回
        RegisterResult registerResult = new RegisterResult();
        registerResult.setAccount(userDo.getAccount());
        registerResult.setRegister(true);
        registerResult.setMessage("注册成功");
        return registerResult;
    }
}
