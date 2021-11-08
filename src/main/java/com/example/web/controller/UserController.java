package com.example.web.controller;

import com.example.web.Result;
import com.example.web.service.UserService;
import com.example.web.util.identifyingCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping(value = "/register")
    //验证码是否正确，邮箱是否被注册，邮箱是否存在
    Result register(@RequestParam(value="email") String email, @RequestParam(value = "password") String password,@RequestParam(value = "type") int type,@RequestParam(value = "identifyCode") String identityCode){
        Result result=new Result();
        if(userservice.register(email,password,type,identityCode)==1){
            result.setCode(100);
            result.setMessage("注册成功");
        }else if(userservice.register(email,password,type,identityCode)==0){
            result.setCode(0);
            result.setMessage("验证码错误");
        }else if(userservice.register(email,password,type,identityCode)==4){
            result.setCode(300);
            result.setMessage("验证码已失效");
        }else{
            result.setCode(200);
            result.setMessage("邮箱已被注册");
        }
        return result;
    }
    @PostMapping(value = "/sendIdentityCode")
    Result sendCode(@RequestParam(value="email") String email){
        userservice.sendCode(email);
        Result result=new Result(100,"验证码已发送");
        return result;
    }
    @PostMapping(value = "/login")
    Result login(@RequestParam(value = "email") String email,@RequestParam(value="pw") String pw){
        Result result=new Result();
        String token=userservice.login(email,pw);
        if("用户未注册".equals(token)){
            result.setCode(0);
            result.setMessage("用户未注册");
        }else if("密码错误".equals(token)){
            result.setCode(200);
            result.setMessage("密码错误");
            result.setData(token);
        }else{
            result.setCode(100);
            result.setMessage("登录成功");
            result.setData(token);
        }
        return result;
    }

}
