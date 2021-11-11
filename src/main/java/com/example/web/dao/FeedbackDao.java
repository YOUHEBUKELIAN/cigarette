package com.example.web.dao;

import org.apache.ibatis.annotations.Param;

public interface FeedbackDao {
    void addFeedbackRecord(@Param("description")String description,
                           @Param("picUrl")String picUrl,
                           @Param("name")String name,
                           @Param("uid")long uid,
                           @Param("type")int type);
}
