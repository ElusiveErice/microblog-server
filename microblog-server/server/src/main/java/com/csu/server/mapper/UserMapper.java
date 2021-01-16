package com.csu.server.mapper;

import com.csu.server.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> query();
}
