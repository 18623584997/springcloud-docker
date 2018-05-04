package com.dahu.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zzh on 2018/3/26.
 */
@Component
public class Receiver {
  @RabbitListener(queues = "hello.queue1")
  public String processMessage1(String msg) {
    System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
    return msg.toUpperCase();
  }

  @RabbitListener(queues = "hello.queue2")
  public void processMessage2(String msg) {
    System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
  }
}
