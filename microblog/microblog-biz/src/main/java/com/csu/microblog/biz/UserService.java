package com.csu.microblog.biz;

import com.csu.microblog.biz.exceptions.user.NullFileException;
import com.csu.microblog.biz.model.LoginResult;
import com.csu.microblog.biz.model.RegisterResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    LoginResult login(long account, String password);

    RegisterResult register(String userName, String password, int sex, MultipartFile portrait) throws NullFileException, IOException;
}
