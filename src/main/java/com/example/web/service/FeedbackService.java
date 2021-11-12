package com.example.web.service;

import com.example.web.dao.FeedbackDao;
import com.example.web.dao.UserDao;
import com.example.web.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;
    @Autowired
    private UserDao userDao;
    //增加一条反馈记录，保存图片
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
    //返回三种类型的反馈列表，未审核，已通过，不通过
    public List<List<Feedback>> getFeedbackList(){
        List<List<Feedback>> list=new ArrayList<>();
        list.add(feedbackDao.returnNonCheckFeedbackList());
        List<Feedback> processed=feedbackDao.returnPassFeedbackList();
        processed.addAll(feedbackDao.returnNotPassFeedbackList());
        list.add(processed);

        return list;
    }
    //管理员通过反馈记录
    public void passFeedback(int id,String amail){
        feedbackDao.pass(id,amail);
    }
    //管理员不通过反馈记录
    public void notPassFeedback(int id,String amail){
        feedbackDao.notPass(id,amail);
    }
}
