package com.dahu.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zzh on 2018/4/23.
 */
@FeignClient(name="compute-server")
public interface Hello2Service {

  @RequestMapping(value = "/hello1")
  public String hello1(@RequestParam(value = "name") String name);

  @RequestMapping(value = "/hello2")
  public String hello2(@RequestParam(value = "name") String name);

}
