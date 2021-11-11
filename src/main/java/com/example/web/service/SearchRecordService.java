package com.example.web.service;

import com.example.web.dao.SearchRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchRecordService {
    @Autowired
    private SearchRecordDao searchRecordDao;
    @Autowired
    private RedisTemplate redisTemplate;


    public List<List<String>> getTrueAndFalseList(String name){
        //搜索一次该香烟score+1
        ZSetOperations zSetOperations=redisTemplate.opsForZSet();
        if(zSetOperations.rank("score",name)==null){
            zSetOperations.add("score",name,1);
        }else{
            zSetOperations.incrementScore("score",name,1);
        }
        List<List<String>> two=new ArrayList<List<String>>();
        two.add(searchRecordDao.getFalseCigarette(name));
        two.add(searchRecordDao.getTrueCigarette(name));
        return two;
    }
}
