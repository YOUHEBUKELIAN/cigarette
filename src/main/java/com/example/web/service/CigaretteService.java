package com.example.web.service;

import com.example.web.dao.CigaretteDao;
import com.example.web.entity.Cigarette;
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
    public boolean pictureRecognize(MultipartFile picture){
        //todo 访问python接口
        String name="白沙";
        int type=1;
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
        return true;

    }
}
