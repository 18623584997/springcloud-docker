package cn.dahu.elasticjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by zzh on 2018/3/6.
 */
@SpringBootApplication
public class ComputeServiceApplication {

  public static void main(String[] args) {
    //EmbedZookeeperServer.start(6181);
    SpringApplication.run(ComputeServiceApplication.class, args);
  }

}
