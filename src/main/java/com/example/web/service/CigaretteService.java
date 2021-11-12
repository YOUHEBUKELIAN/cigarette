package com.example.web.service;

import com.example.web.dao.CigaretteDao;
import com.example.web.entity.Cigarette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CigaretteService {
    @Autowired
    private CigaretteDao cigaretteDao;

    public List<List<Cigarette>> getAllCigarette(){
        List<List<Cigarette>> list=new ArrayList<>();
        list.add(cigaretteDao.getAllFalseCigarettes());
        list.add(cigaretteDao.getAllTrueCigarettes());
        return list;
    }
}
