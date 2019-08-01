package kagura.example.third;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/1 11:40
 * @since 1.0.0
 */
public class Produce {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2. 设置连接属性
        factory.setHost("192.168.0.169");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        // 3. 获取连接
        Connection connection = factory.newConnection();

        Map<String, Object> header = new HashMap<>();
        header.put("wo", "222");
        header.put("shi", 3333);
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .appId("111").deliveryMode(2).expiration("10000")
                .contentEncoding("UTF-8").headers(header).build();

        // 4. 获取Channel
        Channel channel = connection.createChannel();
        // 5. 指定exchange,routingKey,发送消息
        for (int i = 0; i < 5; i++) {
            // 如果exchange为空, 则routingKey = queueName
            String exchange = "properties_exchange";
            String routingKey = "properties_routingKey";
            byte[] message = ("Hello " + i).getBytes();
            channel.basicPublish(exchange, routingKey, properties, message);
        }
        // 6. 关闭Channel,关闭连接
        channel.close();
        connection.close();
    }
}
