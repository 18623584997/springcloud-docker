package com.dahu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by zzh on 2018/3/6.
 */
@SpringBootApplication
public class ConfigClientApplication {

  public static void main(String[] args) {
    //SpringApplication.run(ConfigClientApplication.class, args);
    new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
  }

}
