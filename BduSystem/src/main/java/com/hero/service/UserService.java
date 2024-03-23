package com.hero.service;

import com.hero.pojo.User;

/**
 * @author Heroxin
 * @create 2022-03-31-16:31
 * @Description:
 */
public interface UserService {
    //    用户登录
    User query(User user);

    //    添加用户
    void insert(User user);
}
