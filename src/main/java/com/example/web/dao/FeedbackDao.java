package com.example.web.dao;

import com.example.web.entity.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackDao {
    void addFeedbackRecord(@Param("description")String description,
                           @Param("picUrl")String picUrl,
                           @Param("name")String name,
                           @Param("uid")long uid,
                           @Param("type")int type);

    /**
     *
     * @return 返回未审核反馈列表
     */
    List<Feedback> returnNonCheckFeedbackList();

    /**
     *
     * @return 返回已通过反馈列表
     */
    List<Feedback> returnPassFeedbackList();

    /**
     *
     * @return 返回未通过反馈列表
     */
    List<Feedback> returnNotPassFeedbackList();

    /**
     *
     * @param id 审核记录id
     * @param amail 管理员名字
     * 通过审核操作，更新数据库aid，status
     */
    void pass(int id,String amail);
    /**
     *
     * @param id 审核记录id
     * @param amail 管理员名字
     * 不通过审核操作，更新数据库aid，status
     */
    void notPass(int id,String amail);
}
