package com.zys.redisdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhongyushi
 * @date 2020/9/14 0014
 * @dec 用户实体
 */
@Data
public class User implements Serializable {

    private String username;

    private String name;

    private Integer age;

    private Integer sex;

    private String address;


}
