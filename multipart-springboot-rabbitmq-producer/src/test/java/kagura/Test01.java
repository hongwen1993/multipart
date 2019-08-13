package kagura;


import kagura.producer.RabbitSender;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/5 13:54
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    RabbitSender rabbitSender;

    @Test
    public void test01() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("number", 1234567);
        properties.put("send_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        rabbitSender.send("niu pi de ren ", properties);
    }


}
