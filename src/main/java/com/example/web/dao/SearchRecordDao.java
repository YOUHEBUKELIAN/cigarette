package com.example.web.dao;

import com.example.web.entity.Cigarette;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchRecordDao {
    /**
     *
     * @param name 香烟名字
     * @return list 真香烟列表
     */
    List<Cigarette> getTrueCigarette(@Param("name")String name);

    List<Cigarette> getFalseCigarette(@Param("name")String name);
}
