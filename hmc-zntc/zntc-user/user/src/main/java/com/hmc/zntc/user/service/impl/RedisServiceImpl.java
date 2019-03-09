package com.hmc.zntc.user.service.impl;

import com.hmc.zntc.user.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 图片验证码5分钟
     *
     * @param key
     * @param value
     * @param second
     * @return
     */
    @Override
    public Object setCode(String key, String value, Integer second) {
        redisTemplate.opsForValue().set(key, value, 360, TimeUnit.SECONDS);
        return true;
    }


    /**
     * 短信验证码
     *
     * @param key
     * @param value
     * @param day   保存多少天
     * @return
     */
    @Override
    public boolean setDay(String key, String value, Integer day) {
        redisTemplate.opsForValue().set(key, value, day, TimeUnit.DAYS);
        return true;
    }

    /**
     * 获取key
     *
     * @param key
     * @return
     */
    @Override
    public String get(final String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value != null) {
            return value.toString();
        }
        return null;
    }


    /**
     * 清除
     *
     * @param key
     * @return
     */
    @Override
    public boolean remove(final String key) {
        return redisTemplate.delete(key);
    }


}

