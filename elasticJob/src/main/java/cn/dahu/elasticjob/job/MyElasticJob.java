package cn.dahu.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by zzh on 2018/6/15.
 */
public class MyElasticJob implements SimpleJob {

  @Override
  public void execute(ShardingContext context) {
    System.out.println("---------------sssssssssssssss-------------------");
    switch (context.getShardingItem()) {
      case 0:
        System.out.println(context.getShardingParameter()+"----"+context.getTaskId()+"--"+context.getShardingItem());
        // do something by sharding item 0
        break;
      case 1:
        // do something by sharding item 1
        System.out.println(context.getShardingParameter()+"----"+context.getTaskId()+"--"+context.getShardingItem());
        break;
      case 2:
        // do something by sharding item 2
        System.out.println(context.getShardingParameter()+"----"+context.getTaskId()+"--"+context.getShardingItem());
        break;
      // case n: ...
    }
    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
  }
}
