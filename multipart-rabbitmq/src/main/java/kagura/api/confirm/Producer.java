package kagura.api.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
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
        // 获取连接
        Connection connection = RabbitMQUtils.getDefaultConnection();
        // 获取Channel
        Channel channel = connection.createChannel();
        // 开启确认模式
        channel.confirmSelect();
        // 定向与填充内容
        String exchange = "test_confirm_exchange";
        String routingKey = "confirm.save";
        String message = "I am confirm producer";
        // 发送
        channel.basicPublish(exchange, routingKey, null, message.getBytes());
        // 监听
        channel.addConfirmListener(new ConfirmListener() {

            /**
             * 收到消费端发送的"Ack"
             * @param deliveryTag    会话的名字 - 每一个消息都带有的一个唯一字符串
             * @param multiple       是否是批量处理 - 一般都为false
             */
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {

                System.out.println(deliveryTag + " : successful");
                System.out.println(multiple);
            }

            /**
             * 收到消费端发送的"No-Ack"
             */
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {

                System.out.println(deliveryTag + " : failed");
            }

        });


    }
}
