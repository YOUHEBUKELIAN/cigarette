package com.example.web.controller;

import com.example.web.Result;
import com.example.web.service.CigaretteService;
import com.example.web.service.SearchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cigarette")
@CrossOrigin
public class CigaretteController {
    @Autowired
    private SearchRecordService searchRecordService;
    @PostMapping("/search")
    Result searchCigarette(@RequestParam("name")String name){
        Result r=new Result(100,"查询成功");

        List<List<String>> lis=searchRecordService.getTrueAndFalseList(name);
        r.setData(lis);
        return r;
    }
}
