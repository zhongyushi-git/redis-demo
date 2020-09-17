package com.zys.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisDemoApplicationTests {

    //当存储的值是string类型时使用
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //当存储的值是对象类型时使用
    @Autowired
    private RedisTemplate redisTemplate;


    //string类型的操作，使用opsForValue
    @Test
    public void stringSet(){
        stringRedisTemplate.opsForValue().set("name","张三");
    }
    @Test
    public void stringGet(){
        String s = stringRedisTemplate.opsForValue().get("name");
        System.out.println(s);
    }


    //设值字段的超时时间,单位是秒，超过时间后redis会自动删除
    @Test
    public void keyTimeOut(){
        stringRedisTemplate.expire("name",10, TimeUnit.SECONDS);
    }
    //判断key存在
    @Test
    public void keyIsExists(){
        Boolean exists = stringRedisTemplate.hasKey("name");
        System.out.println(exists);
    }
    //删除key
    @Test
    public void keyDelete(){
        stringRedisTemplate.delete("name");
    }

    //list类型的操作，使用opsForList
    @Test
    public void listSet(){
        stringRedisTemplate.opsForList().leftPush("lists","zhangsan");
        stringRedisTemplate.opsForList().leftPushAll("lists","李敏","李四","赵丽");
    }
    @Test
    public void listGet(){
        List<String> lists =  stringRedisTemplate.opsForList().range("lists",0,-1);
        System.out.println(lists);
    }

    //set类型的操作，使用opsForSet
    @Test
    public void setSet(){
        stringRedisTemplate.opsForSet().add("set","123","456","789","456","666","999","啧啧啧");
    }
    @Test
    public void setGet(){
        Set<String> set = stringRedisTemplate.opsForSet().members("set");
        System.out.println(set);
    }

    //zset类型的操作，使用opsForZSet
    @Test
    public void zsetSet(){
        stringRedisTemplate.opsForZSet().add("zset","张三",10);
        stringRedisTemplate.opsForZSet().add("zset","李四",20);
        stringRedisTemplate.opsForZSet().add("zset","王五",30);
    }
    @Test
    public void zsetGet(){
        Set<String> set = stringRedisTemplate.opsForZSet().range("zset",0,-1);
        System.out.println(set);
    }

    //hash类型的操作，使用opsForHash
    @Test
    public void hashSet(){
        stringRedisTemplate.opsForHash().put("maps","name","张三");
        stringRedisTemplate.opsForHash().put("maps","age","20");
        stringRedisTemplate.opsForHash().put("maps","sex","男");
    }
    @Test
    public void hashGet(){
        Map<Object, Object> maps = stringRedisTemplate.opsForHash().entries("maps");
        System.out.println(maps);
    }

}
