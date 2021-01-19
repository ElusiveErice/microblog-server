package com.csu.server.controller;

import com.csu.server.mapper.LoginMapper;
import com.csu.server.model.*;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private LoginMapper loginMapper;

    @ResponseBody
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Response<LoginData> login(@RequestBody LoginUser loginUser){
        Response<LoginData> response = new Response();
        LoginData loginData = new LoginData();
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setAccount(loginUser.getAccount());
        loginData.setUserInfo(userInfo);

        String password = loginMapper.login(loginUser.getAccount());
        if(password== null || !password.equals(loginUser.getPassword())){
            loginData.setResult(false);
            if(password == null){
                userInfo.setMessage("账号不存在");
            }
            else{
                userInfo.setMessage("密码错误");
            }
        }
        else{
            loginData.setResult(true);
        }
        response.setCode(0);
        response.setData(loginData);

        return response;
    }


}
