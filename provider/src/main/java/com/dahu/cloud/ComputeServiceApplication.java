package com.dahu.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zzh on 2018/3/6.
 */
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
@SpringBootApplication
public class ComputeServiceApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
  }

}
