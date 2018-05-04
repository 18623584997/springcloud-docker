package com.dahu.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zzh on 2018/3/6.
 */
@FeignClient(name="compute-server")
public interface HelloService {
  @RequestMapping(value = "/hello")
  public String hello(@RequestParam(value = "name") String name);
}
