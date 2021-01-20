package com.csu.microblog.web.Controller;

import com.csu.microblog.biz.UserService;
import com.csu.microblog.biz.exceptions.user.NullFileException;
import com.csu.microblog.web.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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
    public APIResult login(@RequestParam long account, @RequestParam String password){
        return APIResult.createResult(userService.login(account, password));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public APIResult register(@RequestParam String userName, @RequestParam String password,
                              @RequestParam int sex,@RequestParam MultipartFile portrait){

        APIResult apiResult = APIResult.okResult();
        try {
            apiResult = APIResult.createResult(userService.register(userName, password, sex, portrait));
        }catch (NullFileException nfe){
            apiResult = APIResult.createResult(APIResult.PARAMETE_ERROR);
        } catch (IOException e) {
            apiResult = APIResult.createResult(APIResult.IO_ERROR);
        }


        return apiResult;
    }

}
