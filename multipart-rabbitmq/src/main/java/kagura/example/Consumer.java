package kagura.example;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/1 11:41
 * @since 1.0.0
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
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
        // 5. 在该Channel中声明一个队列
        String exchange = "test_exchange";
        String exchangeType = "direct";
        String routingKey = "test_routingKey";
        String queueName = "test01";
        // 声明一个交换机
        channel.exchangeDeclare(exchange, exchangeType, true, false,
                false, null);
        // 声明一个队列
        channel.queueDeclare(queueName, true, false, false, null);
        // 建立关系,绑定,类似于第三方关联表
        channel.queueBind(queueName, exchange, routingKey);
        // 6. 创建消费者对象
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 7. 绑定Channel与消费者
        channel.basicConsume("test01", true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody(), Charset.forName("UTF-8"));
            System.out.println("message : " + message);
            Envelope envelope = delivery.getEnvelope();
            System.out.println(envelope);
        }
        //channel.close();
        //connection.close();
    }
}
