package com.example.web.config;

import com.example.web.annotation.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zl
 * @date 2021/11/9
 */
@Component
public class Handle implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //拦截获取添加在适配器上的注解，判断是否有添加的放行注解
        HandlerMethod method = (HandlerMethod) handler;

        Filter filterFrom = method.getMethodAnnotation(Filter.class);

        /**
         * 添加了filterfrom注解就进行登录验证
         *
         *
         * 请求的方法可以有注解，也可以没有，有注解的情况下，进行判断值，如果是没注解的情况下呢，默认			拦截？
         *  没注解就直接拦截，禁止请求。
         *      解决办法：(自定义一个方法，返回boolean方法，获取token的方法。）
         */

        //获取添加在方法上的注解，判断是否存在放行注解
        if (filterFrom != null) {
            //如果设置放行注解为true，就直接放行
            if (filterFrom.value()) {
                return true;
            } else {
                return doFilter(request, response);
            }
        }
        //没添加注解，进行返回提示
        return noDoFilter(request, response);
    }

    @Autowired
    private RedisTemplate redisTemplate;
    public boolean doFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        //默认为false，拦截获取token
        String token = null;
        try {
            token = request.getHeader("Authorization");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (token!=null) {
            //获取redis中token的key对应的value，即邮箱
            String usermail =(String) redisTemplate.opsForValue().get(token);
            //获取redis中token的key储存的val

            if (usermail != null) {
                //请求进来就刷新一次token的有效期
                redisTemplate.expire(token,2, TimeUnit.MINUTES);

                return true;
            } else {
                response.getWriter().print("登录有效期已过，请重新登陆");
                return false;
            }
        } else {
            response.getWriter().print("您还没有登录，请登陆");
            return false;
        }
    }

    public static boolean noDoFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print("您还没有登录，请登陆");
        return false;
    }


}
