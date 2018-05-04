package com.dahu.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zzh on 2018/3/6.
 */
@RestController
public class TestController {

  @RequestMapping("/hello")
  public String hello(String name){
    return "hello"+name;
  }

  @RequestMapping("/hello1")
  public String hello1(String name){
    return "hello1"+name;
  }


  @RequestMapping("/hello2")
  public String hello2(String name){
    return "hello2"+name;
  }


  @RequestMapping("/hello3")
  public String hello3(String name){
    return "hello3"+name;
  }

  @RequestMapping("/hello4")
  public String hello4(String name){
    return "hello4"+name;
  }

  @RequestMapping("/hello5")
  public String hello5(String name){
    return "hello5"+name;
  }
}
