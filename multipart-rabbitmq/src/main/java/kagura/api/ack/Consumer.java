package kagura.api.ack;

import com.rabbitmq.client.*;
import kagura.utils.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
        String exchange = "test_ack_exchange";
        String routingKey = "ack.#";
        String queueName = "test_ack_queue";
        channel.exchangeDeclare(exchange, "topic");

        Map<String, Object> map = new HashMap<>();
        //map.put("x-message-ttl", 20000);
        channel.queueDeclare(queueName, true, false, false, map);
        channel.queueBind(queueName, exchange, routingKey);
        //channel.basicQos(0, 3, false);

        channel.basicConsume(queueName, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                //System.err.println("consumerTag : " + consumerTag);
                //System.err.println("envelope : " + envelope);
                //System.err.println("properties : " + properties);
                //System.err.println("message : " + new String(body, Charset.forName("UTF-8")));
                Map<String, Object> headers = properties.getHeaders();
                if(Objects.equals(headers.get("number"), 3)) {
                    System.err.println("发送Nack");
                    channel.basicNack(envelope.getDeliveryTag(), false, false);
                } else {
                    System.err.println("发送Ack");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
