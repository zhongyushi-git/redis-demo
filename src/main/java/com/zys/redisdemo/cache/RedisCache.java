package com.zys.redisdemo.cache;

import com.zys.redisdemo.util.ApplicationContextUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author zhongyushi
 * @date 2020/9/16 0016
 * @dec 配置redis缓存，使用redis作为缓存服务器，减轻mysql服务器的访问压力
 */
public class RedisCache implements Cache {

    //是mybatis必须要求的，必写。此id是xml中的namespace的值
    private final String id;
    public RedisCache(String id){
        this.id=id;
    }

    //返回cache的唯一名称
    @Override
    public String getId() {
        return this.id;
    }


    //缓存存值
    @Override
    public void putObject(Object key, Object value) {
        //id是namespace的值，key是方法名，value是查询的结果
        getRedisTemplate().opsForHash().put(id,md5AsHex(key.toString()),value);
    }

    //缓存取值
    @Override
    public Object getObject(Object key) {
        return getRedisTemplate().opsForHash().get(id,md5AsHex(key.toString()));
    }

    //mybatis保留方法
    @Override
    public Object removeObject(Object key) {
        return null;
    }

    //清空缓存，在增删改时会自动调用
    @Override
    public void clear() {
        getRedisTemplate().delete(id);
    }

    //缓存的数量
    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
}

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    //获取RedisTemplate,不能通过注入的方式，原因是此类是由mybatis实例化的
    private RedisTemplate getRedisTemplate(){
        //从上下文中获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        //设置key是string类型的序列
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置hashKey是string类型的序列
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    //给定的字符串进行md5加密，转为32位的16进制
    private String md5AsHex(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
