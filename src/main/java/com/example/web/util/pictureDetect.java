package com.example.web.util;

import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author zl
 * @date 2021/11/12
 */
public class pictureDetect {
    public static void postPicture(MultipartFile file) {
        String url = "http://localhost:8080/cigarette/test";
        //文件路径

        RestTemplate rest = new RestTemplate();
        //获取本地文件
        FileSystemResource resource = new FileSystemResource((File) file);
        //将本地文件编辑为formdata格式的数据
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
        param.add("file", resource);

        //发送post请求，并获取返回信息
        ResponseEntity<String> responseEntity = rest.postForEntity(url, param, String.class);
        ;
        System.out.println(responseEntity);
    }

}
