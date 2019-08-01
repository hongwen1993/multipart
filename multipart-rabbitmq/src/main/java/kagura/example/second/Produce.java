package kagura.example.second;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
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
        // 4. 获取Channel
        Channel channel = connection.createChannel();
        // 5. 指定exchange,routingKey,发送消息
        for (int i = 0; i < 5; i++) {
            // 如果exchange为空, 则routingKey = queueName
            String exchange = "topic_exchange";
            String routingKey = "test.user";
            byte[] message = ("Hello" + i).getBytes();
            channel.basicPublish(exchange, routingKey, null, message);
        }
        // 6. 关闭Channel,关闭连接
        channel.close();
        connection.close();
    }
}
