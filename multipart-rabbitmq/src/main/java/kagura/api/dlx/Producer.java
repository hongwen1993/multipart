package kagura.api.dlx;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import kagura.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.Charset;
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
        String exchange = "test_dlx_exchange";
        String routingKey = "dlx.save";
        String message = "I am dlx ";
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .contentEncoding("UTF-8")
                .expiration("15000")
                .build();
        channel.basicPublish(exchange, routingKey, true, properties, message.getBytes());
    }
}
