package com.zys.redisdemo.service.impl;

import com.zys.redisdemo.dao.UserDao;
import com.zys.redisdemo.entity.User;
import com.zys.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        userDao.deleteByUsername(username);
    }
}
