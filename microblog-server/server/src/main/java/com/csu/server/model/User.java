package com.csu.server.model;

import lombok.Data;

@Data
public class User {
    private  long account;
    private String password;
    private String userName;
    private int sex;
}
