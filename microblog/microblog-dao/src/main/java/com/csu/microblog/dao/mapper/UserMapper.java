package com.csu.microblog.dao.mapper;

import com.csu.microblog.dao.entity.UserDo;

import java.util.List;

public interface UserMapper {

    public UserDo login(long account);

    public long register(UserDo userDo);

    public List<UserDo> findUsers();
}
