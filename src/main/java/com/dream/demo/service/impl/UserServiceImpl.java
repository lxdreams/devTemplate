package com.dream.demo.service.impl;

import com.dream.demo.dao.UserMapper;
import com.dream.demo.entity.User;
import com.dream.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getAll(User user) {
        return userMapper.getAll(user);
    }
}
