package cn.dahu.elasticjob;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zzh on 2018/6/15.
 */
public class JobBoot {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/job.xml");
    context.start();
    try {
      Thread.sleep(Integer.MAX_VALUE);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
