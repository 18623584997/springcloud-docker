import com.dahu.cloud.ServerApplication;
import com.dahu.cloud.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zzh on 2018/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class MailServiceTest {

  @Autowired
  private MailService mailService;

  @Test
  public void sendTest(){
    mailService.sendMail("214785256@qq.com","阿斯顿发大","阿斯顿发打发");
  }


}
