package com.hero.service.impl;

import com.hero.mapper.UserMapper;
import com.hero.pojo.User;
import com.hero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Heroxin
 * @create 2022-03-31-16:31
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User query(User user) {
        try {
            return userMapper.query(user);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,readOnly = false,propagation = Propagation.REQUIRED)
    public void insert(User user) {
        userMapper.insert(user);
    }
}
