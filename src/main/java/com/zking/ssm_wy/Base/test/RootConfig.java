package com.zking.ssm_wy.Base.test;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class RootConfig {

    /**
     * 配置邮件发送器
     * @return
     */
    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(25);//默认端口，标准的SMTP端口
        mailSender.setUsername("3222856230");//用户名
        mailSender.setPassword("shijianzhuyu777");//密码
        return mailSender;
    }
}
