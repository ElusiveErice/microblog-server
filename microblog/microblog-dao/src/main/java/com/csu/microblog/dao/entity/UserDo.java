package com.csu.microblog.dao.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDo {
    private long account;
    private String password;
    private String userName;
    private int sex;
    private String portrait;
    private Date birthday;
}
