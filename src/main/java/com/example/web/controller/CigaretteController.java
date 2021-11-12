package com.example.web.controller;

import com.example.web.Result;
import com.example.web.annotation.Filter;
import com.example.web.entity.Cigarette;
import com.example.web.service.CigaretteService;
import com.example.web.service.SearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/cigarette")
@CrossOrigin
public class CigaretteController {
    @Autowired
    private SearchRecordService searchRecordService;
    @Autowired
    private CigaretteService cigaretteService;
    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("/search")
    @Filter(true)
    Result searchCigarette(@RequestParam("name")String name){
        Result r=new Result(100,"查询成功");

        List<List<Cigarette>> lis=searchRecordService.getTrueAndFalseList(name);
        r.setData(lis);
        return r;
    }
    @GetMapping("/getAllCigarettes")
    @Filter(true)
    Result getAllCigarette(){
        Result r=new Result(100,"查询成功");
        r.setData(cigaretteService.getAllCigarette());
        return r;
    }

    @GetMapping("/getRank")
    @Filter
    Result getRank(){
        Result r=new Result(100,"查询成功");
        r.setData(searchRecordService.getRank());

        return r;
    }
    @PostMapping("/pictureRecognize")
    Result pictureRecognize(@RequestParam("picture")MultipartFile picture){
        Result r=new Result(100,"上传成功");
        r.setData(cigaretteService.pictureRecognize(picture));
        return r;
    }
    @PostMapping("/test")
    Result test(@RequestParam("file")MultipartFile file){
        Result r=new Result(100,"上传成功");
        r.setData("白沙");
        return r;
    }
}
