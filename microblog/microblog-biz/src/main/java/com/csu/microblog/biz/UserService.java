package com.csu.microblog.biz;

import com.csu.microblog.biz.model.LoginInfo;
import com.csu.microblog.biz.model.LoginResult;
import com.csu.microblog.biz.model.RegisterInfo;
import com.csu.microblog.biz.model.RegisterResult;

public interface UserService {

    LoginResult login(LoginInfo loginInfo);

    RegisterResult register(RegisterInfo registerInfo);
}
