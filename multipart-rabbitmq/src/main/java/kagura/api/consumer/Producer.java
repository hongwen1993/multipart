package kagura.api.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import kagura.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/6 10:31
 * @since 1.0.0
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getDefaultConnection();
        Channel channel = connection.createChannel();
        String exchange = "test_consumer_exchange";
        String routingKey = "consumer.save";
        for (int i = 0; i < 5; i++) {
            String message = "I am consumer consumer " + i;
            channel.basicPublish(exchange, routingKey, true, null, message.getBytes());
        }
    }
}
