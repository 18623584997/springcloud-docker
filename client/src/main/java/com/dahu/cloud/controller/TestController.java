package com.dahu.cloud.controller;

import com.dahu.cloud.service.Hello2Service;
import com.dahu.cloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zzh on 2018/3/6.
 */
@RestController
public class TestController {
  @Autowired
  HelloService helloService;
  //@Value("${user}")
  private String bbc;

  @Autowired
  Hello2Service hello2Service;

  @RequestMapping("/cc.htm")
  public String tt(){
    String str = helloService.hello("dahu");

    String str2 = hello2Service.hello1("dahu1");
    return str+str2+bbc;
  }

  @RequestMapping("/gg.htm")
  public String gg(){
    return bbc;
  }

}
