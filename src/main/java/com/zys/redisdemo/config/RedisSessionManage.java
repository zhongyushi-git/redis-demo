package com.zys.redisdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author zhongyushi
 * @date 2020/9/17 0017
 * @dec redis session管理配置
 */
@Configuration
//把整个应用中使用session的数据全部存入redis
@EnableRedisHttpSession
public class RedisSessionManage {
}
