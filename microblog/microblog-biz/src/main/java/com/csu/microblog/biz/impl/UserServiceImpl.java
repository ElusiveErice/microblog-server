package com.csu.microblog.biz.impl;

import com.csu.microblog.biz.UserService;
import com.csu.microblog.biz.exceptions.user.NullFileException;
import com.csu.microblog.biz.model.LoginResult;
import com.csu.microblog.biz.model.RegisterResult;
import com.csu.microblog.dao.entity.UserDo;
import com.csu.microblog.dao.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserMapper userMapper;

    @Override
    public LoginResult login(long account, String password) {
        LoginResult loginResult = new LoginResult();

        UserDo userDo = userMapper.login(account);

        if (userDo == null) {
            loginResult.setLogin(false);
            loginResult.setMessage("账号不存在");
        } else if (userDo.getPassword().equals(password)) {
            loginResult.setLogin(true);
            loginResult.setMessage("登录成功");
            loginResult.setAccount(account);
            loginResult.setUserName(userDo.getUserName());
        } else {
            loginResult.setLogin(false);
            loginResult.setMessage("密码不正确");
        }

        logger.info("处理登录请求结果:" + loginResult);
        return loginResult;
    }

    @Override
    public RegisterResult register(String userName, String password, int sex,
                                   MultipartFile portrait) throws NullFileException, IOException {
        RegisterResult registerResult = new RegisterResult();
        registerResult.setRegister(false);

        if (portrait.isEmpty()) {
            throw new NullFileException();
        }

        String fileName = portrait.getOriginalFilename();
        List<String> FILE_WHILE_EXT_LIST = Arrays.asList("JPG", "PNG", "JPEG", "GIF");
        Assert.notNull(fileName, "File name can not be empty");
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (FILE_WHILE_EXT_LIST.contains(fileExtName.toUpperCase())) {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/portrait/";

            File dest = new File(path + fileName);
            portrait.transferTo(dest);
        } else {
            registerResult.setMessage("图片格式不正确");
            throw new NullFileException();
        }

        //根据信息去新增一个用户信息
        UserDo userDo = new UserDo();
        userDo.setUserName(userName);
        userDo.setPassword(password);
        userDo.setSex(sex);
        userDo.setPortrait(fileName);
        userMapper.register(userDo);

        //根据插入的结果返回

        registerResult.setAccount(userDo.getAccount());
        registerResult.setRegister(true);
        registerResult.setMessage("注册成功");

        logger.info("注册成功一个账号:" + userDo.getAccount() + ",头像图片路径名:" + fileName);
        return registerResult;
    }
}
