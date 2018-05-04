package com.dahu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zzh on 2018/3/6.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ClientApplication {



  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
  }

}
