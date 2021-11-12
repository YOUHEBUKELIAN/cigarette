package com.example.web.service;

import com.example.web.dao.SearchRecordDao;
import com.example.web.entity.Cigarette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SearchRecordService {
    @Autowired
    private SearchRecordDao searchRecordDao;
    @Autowired
    private RedisTemplate redisTemplate;


    public List<List<Cigarette>> getTrueAndFalseList(String name){
        if("".equals(name)){
            return null;
        }
        //搜索一次该香烟score+1
        ZSetOperations zSetOperations=redisTemplate.opsForZSet();
        if(zSetOperations.rank("score",name)==null){
            zSetOperations.add("score",name,1);
        }else{
            zSetOperations.incrementScore("score",name,1);
        }
        List<List<Cigarette>> two=new ArrayList<List<Cigarette>>();
//        zSetOperations.removeRange("score",0,3);
        two.add(searchRecordDao.getFalseCigarette(name));
        two.add(searchRecordDao.getTrueCigarette(name));
        return two;
    }
    public Set<String> getRank(){
        ZSetOperations zSetOperations=redisTemplate.opsForZSet();
        System.out.println(zSetOperations.range("score",0,10));

        return zSetOperations.reverseRange("score",0,10);
    }
}
