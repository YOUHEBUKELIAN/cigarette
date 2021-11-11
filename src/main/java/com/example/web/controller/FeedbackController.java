package com.example.web.controller;

import com.example.web.Result;
import com.example.web.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Action;

/**
 * @author zl
 * @date 2021/11/10
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/upload")
    Result upload(@RequestParam("description") String description,
                  @RequestParam("file") MultipartFile file,
                  @RequestParam("name")String name,
                  @RequestParam("mail")String mail,
                  @RequestParam("type")int type){
        Result r=new Result(100,"反馈成功");
        try {
            feedbackService.addFeedbackRecord(description,file,name,mail,type);
        }catch (Exception e){
            System.out.println("upload发生异常");
        }
        return r;

    }
}
