package com.dream.demo.service;

import com.dream.demo.entity.User;

import java.util.List;

public interface IUserService {
    int insert(User user);
    List<User> getAll(User user);
}
