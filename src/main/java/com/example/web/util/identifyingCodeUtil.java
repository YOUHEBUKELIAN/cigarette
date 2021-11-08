package com.example.web.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * @author zl
 * @date 2021/11/8
 */
public class identifyingCodeUtil {
    public static String sendIdentifyCode(String email){
        String code=produceIdentifyCode(8);
        try {
            //创建Properties 类用于记录邮箱的一些属性
            final Properties props = new Properties();
            //表示SMTP发送邮件，必须进行身份验证
            props.put("mail.smtp.auth", "true");
            //此处填写SMTP服务器
            props.put("mail.smtp.host", "smtp.qq.com");
            //端口号，QQ邮箱给出了两个端口，这里给出587
            props.put("mail.smtp.port", "587");
            //此处填写你的账号
            props.put("mail.user", "947320114@qq.com");
            //此处的密码就是前面说的16位STMP口令
            //获取口令
            props.put("mail.password", "nzveeuglodehbejd");
            //构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            //使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            //创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            //设置发件人
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);

            //设置收件人的邮箱
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(MimeMessage.RecipientType.TO, to);

            //设置邮件主题
            message.setSubject("测试邮件");
            //设置消息日期
            message.setSentDate(new Date());

            //html文件


            //设置邮件的内容体
            message.setContent(code, "text/html;charset=UTF-8");

            //最后当然就是发送邮件
            Transport.send(message);
            System.out.println("发送成功！");

        } catch (AddressException e) {
            System.out.println("发送失败！"+e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("发送失败！"+e.getMessage());
            e.printStackTrace();
        }
        return code;
    }
    public static String produceIdentifyCode(int n){
        String code="";
        for(int i=0;i<n;i++) {
            Random r = new Random();
            String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
            code=code+s.charAt(r.nextInt(s.length()));
        }
        return code;
    }
}
