package com.csu.microblog.web.Controller;

import com.csu.microblog.biz.UserService;
import com.csu.microblog.biz.model.LoginInfo;
import com.csu.microblog.biz.model.RegisterInfo;
import com.csu.microblog.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello user";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public APIResult login(@RequestBody LoginInfo loginInfo){
        return APIResult.createOkResult(userService.login(loginInfo));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public APIResult register(@RequestBody RegisterInfo registerInfo){
        return APIResult.createOkResult(userService.register(registerInfo));
    }

}
