package com.example.web.controller;

import com.example.web.Result;
import com.example.web.annotation.Filter;
import com.example.web.service.CigaretteService;
import com.example.web.service.SearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cigarette")
@CrossOrigin
public class CigaretteController {
    @Autowired
    private SearchRecordService searchRecordService;
    @Autowired
    private CigaretteService cigaretteService;
    @PostMapping("/search")
    @Filter(true)
    Result searchCigarette(@RequestParam("name")String name){
        Result r=new Result(100,"查询成功");

        List<List<String>> lis=searchRecordService.getTrueAndFalseList(name);
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
}
