package com.zys.redisdemo.dao;


import com.zys.redisdemo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    List<User> getByUsername(@Param("username") String username);

    void deleteByUsername(@Param("username") String username);
}
