package com.csu.server.model;

import lombok.Data;


public class LoginData {
    Boolean result;
    LoginUserInfo userInfo;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public LoginUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(LoginUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
