package com.dahu.rabbit.service;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zzh on 2018/3/26.
 */
@Component
public class Sender  implements RabbitTemplate.ConfirmCallback, ReturnCallback {


  @Autowired
  private RabbitTemplate rabbitTemplate;

  @PostConstruct
  public void init() {
    rabbitTemplate.setConfirmCallback(this);
    rabbitTemplate.setReturnCallback(this);
  }


  @Override
  public void confirm(CorrelationData correlationData, boolean b, String s) {

  }

  @Override
  public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
    System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");

  }

  //发送消息，不需要实现任何接口，供外部调用。
  public void send(String msg){

    CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

    System.out.println("开始发送消息 : " + msg.toLowerCase());
    Object response = rabbitTemplate.convertSendAndReceive("topicExchange", "key1", msg, correlationId);
    if(response==null){
      System.out.println("返回的消息是空");
    }else{
      System.out.println("结束发送消息 : " + msg.toLowerCase());
      System.out.println("消费者响应 : " + response + " 消息处理完成");
    }
    //rabbitTemplate.convertAndSend("topicExchange", "sss", msg, correlationId);

  }


}
