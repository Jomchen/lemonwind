package com.jomkie.common.redis;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTool {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;

    public String get(String key) {
        return strRedisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value) {
        strRedisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long timeLength, TimeUnit timeUnit) {
        strRedisTemplate.opsForValue().set(key, value, timeLength, timeUnit);
    }

    /**
     * @author Jomkie
     * @since 2021-05-23 21:2:19
     * @param key 对象的 key
     * @param typeReference 转换引用
     * 查询一个对象
     */
    public <T> T get(String key, TypeReference<T> typeReference) {
        String valueJson = strRedisTemplate.opsForValue().get(key);
        T resultData = Optional.ofNullable(valueJson)
                .map(v -> JSONObject.parseObject(valueJson, typeReference))
                .orElse(null);
        return resultData;
    }

    /**
     * @author Jomkie
     * @since 2021-05-23 21:3:55
     * @param key  存储的 key
     * @param data 存储的对象
     */
    public <T> void set(String key, T data) {
        String valueJson = JSONObject.toJSONString(data);
        strRedisTemplate.opsForValue().set(key, valueJson);
    }

    /**
     * @author Jomkie
     * @since 2021-05-23 21:3:55
     * @param key  存储的 key
     * @param data 存储的对象
     * @param timeLength 时间长度
     * @param timeUnit 时间单位
     */
    public <T> void set(String key, T data, long timeLength, TimeUnit timeUnit) {
        String valueJson = JSONObject.toJSONString(data);
        strRedisTemplate.opsForValue().set(key, valueJson, timeLength, timeUnit);
    }

}