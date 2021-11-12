package com.example.web.controller;

import com.example.web.Result;
import com.example.web.annotation.Filter;
import com.example.web.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Action;

/**
 * @author zl
 * @date 2021/11/10
 */
@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;



    @PostMapping("/upload")
    @Filter(true)
    Result upload(@RequestParam("description") String description,
                  @RequestParam("file") MultipartFile file,
                  @RequestParam("name")String name,
                  @RequestParam("mail")String mail,
                  @RequestParam("type")int type){
        Result r=new Result(100,"反馈成功");


        try {
            feedbackService.addFeedbackRecord(description,file,name,mail,type);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("upload发生异常");
        }
        return r;

    }
}
