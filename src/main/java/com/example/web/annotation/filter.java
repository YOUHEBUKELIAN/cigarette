package com.example.web.annotation;

import java.lang.annotation.*;

/**
 * @author zl
 * @date 2021/11/9
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface filter {
    boolean value() default false;
}
