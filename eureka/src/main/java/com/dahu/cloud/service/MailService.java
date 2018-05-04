package com.dahu.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by zzh on 2018/3/22.
 */
@Service
public class MailService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());


  @Autowired
  private JavaMailSender mailSender;

  @Value("${mail.fromMail.addr}")
  private String from;

  public void sendMail(String to,String subject,String content){

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);

    try {
         mailSender.send(message);
         logger.info("简单邮件已经发送。");
       } catch (Exception e) {
        logger.error("发送简单邮件时发生异常！", e);
       }
  }

}
