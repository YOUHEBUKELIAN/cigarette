package com.example.web.dao;

import com.example.web.entity.Cigarette;
import com.example.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao
 * @author zl
 * @date 2021/11/6
 */
@Mapper
public interface UserDao {
    /**
     * 插入一个用户
     * @param mail 用户的邮箱
     * @param type 用户类型。0：普通用户，1：管理员用户
     * @param password 用户的密码
     */
    void insert(@Param("mail") String mail, @Param("type") int type, @Param("password") String password);

    /**
     *
     * @param mail
     * @return
     */
    int checkMail(@Param("mail") String mail);

    /**
     *
     * @param mail
     * @param mail
     * @return
     */
    List<User> login(@Param("mail") String mail);

    List<Cigarette> getTrueCigarette(@Param("name")String name);
}
