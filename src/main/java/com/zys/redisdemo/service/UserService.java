package com.zys.redisdemo.service;


import com.zys.redisdemo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<User> getByUsername(String username);

    void deleteByUsername(String username);
}
