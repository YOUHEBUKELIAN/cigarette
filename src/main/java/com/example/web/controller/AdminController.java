package com.example.web.controller;

import com.example.web.Result;
import com.example.web.annotation.Filter;
import com.example.web.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/getFeedbackList")
    @Filter(value = true)
    //获取所有反馈列表
    Result getFeedbackList(){
        Result r= new Result(100,"获取反馈列表成功");
        r.setData(feedbackService.getFeedbackList());
        return r;
    }
    @PostMapping("/passFeedback")
    //通过反馈记录
    Result passFeedback(@RequestParam("id")int id,@RequestParam("amail")String amail){
        Result r=new Result(100,"操作成功");
        feedbackService.passFeedback(id,amail);
        return r;
    }
    @PostMapping("/notPassFeedback")
        //通过反馈记录
    Result notPassFeedback(@RequestParam("id")int id,@RequestParam("amail")String amail){
        Result r=new Result(100,"操作成功");
        feedbackService.notPassFeedback(id,amail);
        return r;
    }




}
