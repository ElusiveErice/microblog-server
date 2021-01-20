package com.csu.microblog.biz.model;

import lombok.Data;

@Data
public class LoginInfo {
    private long account;
    private String password;
}
