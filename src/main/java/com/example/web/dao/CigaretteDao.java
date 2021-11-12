package com.example.web.dao;

import com.example.web.entity.Cigarette;

import java.util.List;

public interface CigaretteDao {
    /**
     *
     * @return 获取所有的真香烟
     */
    List<Cigarette> getAllTrueCigarettes();
    /**
     *
     * @return 获取所有的假香烟
     */
    List<Cigarette> getAllFalseCigarettes();
}
