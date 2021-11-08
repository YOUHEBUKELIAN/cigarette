package com.example.web.service;

import com.example.web.dao.UserDao;
import com.example.web.entity.User;
import com.example.web.util.MD5Util;
import com.example.web.util.identifyingCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserDao userdao;
    @Autowired
    private RedisTemplate redisTemplate;
    public int register(String mail,String password,int type,String identifyCode){

        String identy_code=(String) redisTemplate.opsForValue().get(mail);
        if(identy_code==null){
            return 4;
        }
        if(!identifyCode.equals(identy_code)){
            return 0;//验证码错误
        }
        if(userdao.checkMail(mail)==0){
            userdao.insert(mail,type,password);
            return 1;//注册成功，插入数据
        }else{
            return 2;//邮箱已注册
        }
    }
    public int sendCode(String mail){
        String code=identifyingCodeUtil.sendIdentifyCode(mail);
        redisTemplate.opsForValue().set(mail,code,2, TimeUnit.MINUTES);
        return 1;
    }
    public String login(String mail,String password){
        if(userdao.login(mail).size()==0){
            return "用户未注册";
        }
        User user=userdao.login(mail).get(0);
        if(!user.getPassword().equals(MD5Util.encode(password))){
            return "密码错误";
        }else{
            String token=UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token,mail,120,TimeUnit.MINUTES);
            return token;
        }
    }
}
