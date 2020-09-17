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
class RedisDemoApplicationTests2 {

    //当存储的值是string类型时使用
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //当存储的值是对象类型时使用
    @Autowired
    private RedisTemplate redisTemplate;


    //string类型的操作，使用boundValueOps
    @Test
    public void stringSet(){
        stringRedisTemplate.boundValueOps("name").set("张三");
    }
    @Test
    public void stringGet(){
        String s = stringRedisTemplate.boundValueOps("name").get();
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

    //list类型的操作，使用boundListOps
    @Test
    public void listSet(){
        stringRedisTemplate.boundListOps("lists").leftPush("zhangsan");
        stringRedisTemplate.boundListOps("lists").leftPushAll("李敏","李四","赵丽");
    }
    @Test
    public void listGet(){
        List<String> lists =  stringRedisTemplate.boundListOps("lists").range(0,-1);
        System.out.println(lists);
    }

    //set类型的操作，使用boundSetOps
    @Test
    public void setSet(){
        stringRedisTemplate.boundSetOps("set").add("123","456","789","456","666","999","啧啧啧");
    }
    @Test
    public void setGet(){
        Set<String> set = stringRedisTemplate.boundSetOps("set").members();
        System.out.println(set);
    }

    //zset类型的操作，使用boundZSetOps
    @Test
    public void zsetSet(){
        stringRedisTemplate.boundZSetOps("zset").add("张三",10);
        stringRedisTemplate.boundZSetOps("zset").add("李四",20);
        stringRedisTemplate.boundZSetOps("zset").add("王五",30);
    }
    @Test
    public void zsetGet(){
        Set<String> set = stringRedisTemplate.boundZSetOps("zset").range(0,-1);
        System.out.println(set);
    }

    //hash类型的操作，使用boundHashOps
    @Test
    public void hashSet(){
        stringRedisTemplate.boundHashOps("maps").put("name","张三");
        stringRedisTemplate.boundHashOps("maps").put("age","20");
        stringRedisTemplate.boundHashOps("maps").put("sex","男");
    }
    @Test
    public void hashGet(){
        Map<Object, Object> maps = stringRedisTemplate.boundHashOps("maps").entries();
        System.out.println(maps);
    }

}
