package com.csu.microblog.biz.model;

import lombok.Data;

@Data
public class RegisterResult {
    private boolean register;
    private String message;
    private long account;
}
