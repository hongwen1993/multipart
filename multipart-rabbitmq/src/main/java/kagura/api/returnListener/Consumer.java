package kagura.api.returnListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
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
        String exchange = "test_return_exchange";
        String routingKey = "return.#";
        String queueName = "test_return_queue";
        channel.exchangeDeclare(exchange, "topic");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchange, routingKey);
        // 创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 显示的开启一个消费者
        channel.basicConsume(queueName, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.out.println("message : " + new String(delivery.getBody(), Charset.forName("UTF-8")));
        }
    }
}
