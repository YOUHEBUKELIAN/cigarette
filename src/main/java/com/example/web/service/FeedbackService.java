package com.example.web.service;

import com.example.web.dao.FeedbackDao;
import com.example.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;
    @Autowired
    private UserDao userDao;
    public void addFeedbackRecord(String description, MultipartFile file,String name,String uemail,int type){
        long uid= userDao.emailToUid(uemail);
        //生成不重复图片名字
        String picUrl=name+"/"+name+ UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        File dest = new File("D:\\test/"+picUrl);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        feedbackDao.addFeedbackRecord(description,picUrl,name,uid,type);
    }
}
