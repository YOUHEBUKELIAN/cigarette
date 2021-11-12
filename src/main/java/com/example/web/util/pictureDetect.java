package com.example.web.util;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;


/**
 * @author zl
 * @date 2021/11/12
 */
public class pictureDetect {
    public static String postPicture(MultipartFile file) {
        String url = "http://localhost:8080/cigarette/test";
        //文件路径

        RestTemplate rest = new RestTemplate();

        //multipartfile转file
        //生成不重复图片名字
        String picUrl=UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        File dest = new File("D:\\templ/"+picUrl);
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


        //获取本地文件
        FileSystemResource resource = new FileSystemResource(dest);
        //将本地文件编辑为formdata格式的数据
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
        param.add("file", resource);

        //发送post请求，并获取返回信息
        ResponseEntity<String> responseEntity = rest.postForEntity(url, param, String.class);

        String string=rest.postForObject(url,param,String.class);


        System.out.println(responseEntity);
        return string;
    }

}
