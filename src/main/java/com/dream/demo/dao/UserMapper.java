package com.dream.demo.dao;

import com.dream.demo.entity.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> getAll(User record);
}