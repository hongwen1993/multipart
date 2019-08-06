package kagura.api.confirm;

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
        // 获取连接
        Connection connection = RabbitMQUtils.getDefaultConnection();
        //获取Channel
        Channel channel = connection.createChannel();
        //绑定
        String exchange = "test_confirm_exchange";
        String routingKey = "confirm.#";
        String queueName = "test_confirm_queue";
        channel.exchangeDeclare(exchange, "topic");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchange, routingKey);
        //创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //设置消费模式
        channel.basicConsume(queueName, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.out.println("message : " + new String(delivery.getBody(), Charset.forName("UTF-8")));
        }
    }
}
