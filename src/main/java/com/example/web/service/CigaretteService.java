package com.example.web.service;

import com.alibaba.fastjson.JSONObject;
import com.example.web.dao.CigaretteDao;
import com.example.web.entity.Cigarette;
import com.example.web.util.pictureDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public String[] pictureRecognize(MultipartFile picture){
        //todo 访问python接口

        String string=pictureDetect.postPicture(picture);
        //String转json格式，获取返回的url地址

        JSONObject jsonObject= com.alibaba.fastjson.JSON.parseObject(string);

        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject);
        String name=jsonObject.getString("name");

        int type=Integer.parseInt(jsonObject.getString("type"));

        //生成不重复图片名字
        String picUrl=name+"/"+name+ UUID.randomUUID().toString()+picture.getOriginalFilename().substring(picture.getOriginalFilename().lastIndexOf("."));

        File dest = new File("D:\\test/"+picUrl);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            picture.transferTo(dest);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cigaretteDao.addCigarette(name,picUrl,type);

        String[] s=new String[2];
        s[0]=name;
        s[1]=type+"";

        return s;

    }
}
