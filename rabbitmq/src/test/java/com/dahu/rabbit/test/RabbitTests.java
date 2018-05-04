package com.dahu.rabbit.test;

import com.dahu.rabbit.ServerApplication;
import com.dahu.rabbit.service.Sender;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zzh on 2018/3/26.
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class RabbitTests {

  @Autowired
  private Sender sender;

  @Test
  public void sendTest() throws Exception {
    while(true){
      String msg = new Date().toString();
      sender.send(msg);
     // Thread.sleep(1000);
    }
  }

}
