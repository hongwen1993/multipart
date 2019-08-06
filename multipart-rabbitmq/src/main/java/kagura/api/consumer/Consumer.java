package kagura.api.consumer;

import com.rabbitmq.client.*;
import kagura.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/6 10:31
 * @since 1.0.0
 */
public class Consumer {
    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        Connection connection = RabbitMQUtils.getDefaultConnection();
        Channel channel = connection.createChannel();
        String exchange = "test_consumer_exchange";
        String routingKey = "consumer.#";
        String queueName = "test_consumer_queue";
        channel.exchangeDeclare(exchange, "topic");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchange, routingKey);
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.err.println("consumerTag : " + consumerTag);
                System.err.println("envelope : " + envelope);
                System.err.println("properties : " + properties);
                System.err.println("message : " + new String(body, Charset.forName("UTF-8")));
            }
        });
    }
}
