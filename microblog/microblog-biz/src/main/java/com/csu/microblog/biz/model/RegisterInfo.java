package com.csu.microblog.biz.model;

import lombok.Data;

@Data
public class RegisterInfo {
    private String userName;
    private String password;
    private String portrait;
    private int sex;
}
