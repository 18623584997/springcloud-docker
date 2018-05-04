package com.dahu.cloud.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zzh on 2018/3/6.
 */
@RestController
public class TestController {

  @Value("${name}")
  private String bbc;





  @RequestMapping("/gg.htm")
  public String gg(){
    return bbc;
  }

}
