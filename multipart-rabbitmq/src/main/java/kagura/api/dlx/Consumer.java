package kagura.api.dlx;

import com.rabbitmq.client.*;
import kagura.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
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


        // 声明第1个exchange和queue - 用来存放死信消息
        String dlxExchange = "dlx.exchange";
        String dlxRoutingKey = "#";
        String dlxQueueName = "dlx.queue";
        channel.exchangeDeclare(dlxExchange, RabbitMQUtils.TOPIC);
        channel.queueDeclare(dlxQueueName, true, false, false, null);
        channel.queueBind(dlxQueueName, dlxExchange, dlxRoutingKey);

        // 声明第2个exchange和queue
        String exchange = "test_dlx_exchange";
        String routingKey = "dlx.#";
        String queueName = "test_dlx_queue";

        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", dlxExchange);
        channel.exchangeDeclare(exchange, RabbitMQUtils.TOPIC);
        // 关联到死信队列对应的 Exchange 上
        channel.queueDeclare(queueName, true, false, false, arguments);
        channel.queueBind(queueName, exchange, routingKey);

        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // do something...
            }
        });
    }
}
