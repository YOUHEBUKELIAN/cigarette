package com.example.web.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zl
 * @date 2021/11/8
 */
@SpringBootTest
public class identifyingCodeUtilTests {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void test(){
        String mail="2029078772@qq.com";
        System.out.println((String) redisTemplate.opsForValue().get(mail));
        System.out.println(MD5Util.encode("123"));
        System.out.println(redisTemplate.opsForValue().get("3090f613-34f3-442e-896e-99f2e18eacc9"));
    }
}
