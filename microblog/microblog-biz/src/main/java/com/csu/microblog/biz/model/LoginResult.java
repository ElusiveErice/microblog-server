package com.csu.microblog.biz.model;

import lombok.Data;

@Data
public class LoginResult {
    private boolean login;
    private long account;
    private String message;
    private String userName;
}
