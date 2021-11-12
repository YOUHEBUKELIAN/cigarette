package com.example.web;

import com.example.web.controller.FeedbackController;
import com.example.web.entity.Feedback;
import com.example.web.service.FeedbackService;
import com.example.web.service.SearchRecordService;
import com.example.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import com.example.web.util.pictureDetect;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private FeedbackService feedbackService;
    @Test
    void contextLoads() throws InterruptedException {
        redisTemplate.opsForValue().get("file");
    }


}
