package com.zking.ssm_wy.Base.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheTransfer {
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}
