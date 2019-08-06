package kagura.api.returnListener;

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
        String exchange = "test_return_exchange";
        String routingKey = "return.save";
        String routingKeyError = "abc.save";
        String message = "I am return producer";
        channel.addReturnListener((replyCode, replyText, exchange1, routingKey1, properties, body) -> {
            System.out.println(replyCode);
            System.out.println(replyText);
            System.out.println(exchange1);
            System.out.println(routingKey1);
            System.out.println(properties);
            System.out.println(new String(body));
        });
        // mandatory为false则自动删除
        channel.basicPublish(exchange, routingKeyError, true, null, message.getBytes());






    }
}
