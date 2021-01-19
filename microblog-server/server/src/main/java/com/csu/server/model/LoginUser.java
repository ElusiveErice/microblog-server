package com.csu.server.model;

import lombok.Data;

public class LoginUser {
    private long account;
    private String password;

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
