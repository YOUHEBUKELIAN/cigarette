package com.example.web;

import com.example.web.service.SearchRecordService;
import com.example.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SearchRecordService searchRecordService;
    @Test
    void contextLoads() throws InterruptedException {

//        redisTemplate.opsForValue().set("宝贝","是猪",2, TimeUnit.SECONDS);
//        Thread.sleep(2000);
//        System.out.println((String) redisTemplate.opsForValue().get("宝贝"));

    }


}
