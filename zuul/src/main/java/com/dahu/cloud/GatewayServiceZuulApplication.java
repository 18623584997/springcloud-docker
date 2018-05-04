package com.dahu.cloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zzh on 2018/4/23.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayServiceZuulApplication {
  public static void main(String[] args) {
    SpringApplication.run(GatewayServiceZuulApplication.class, args);
  }
}
