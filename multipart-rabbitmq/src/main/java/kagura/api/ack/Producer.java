package kagura.api.ack;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import kagura.utils.RabbitMQUtils;
import org.springframework.boot.autoconfigure.jms.JmsProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/6 10:31
 * @since 1.0.0
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = RabbitMQUtils.getDefaultConnection();
        Channel channel = connection.createChannel();
        String exchange = "test_ack_exchange";
        String routingKey = "ack.save";
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.err.println(deliveryTag);
                System.err.println("ack");
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(deliveryTag);
                System.out.println("nack");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread.sleep(3000);
            String message = "I am ack " + i;
            Map<String, Object> headers = new HashMap<>();
            headers.put("number", i);
            headers.put("bbb", "kagura");
            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .deliveryMode(JmsProperties.DeliveryMode.PERSISTENT.getValue())
                    .contentEncoding("UTF-8")
                    .headers(headers)
                    //.expiration("15000")
                    .build();
            channel.basicPublish(exchange, routingKey, true, properties, message.getBytes());
        }
    }
}
