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
        //3 获取Channel
        Channel channel = connection.createChannel();
        //4 开启确认模式
        channel.confirmSelect();
        //5 定向与填充内容
        String exchange = "test_confirm_exchange";
        String routingKey = "confirm.save";
        String message = "I am confirm producer";
        //6 发送
        channel.basicPublish(exchange, routingKey, null, message.getBytes());
        //7 监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(deliveryTag + " : successful");
                System.out.println(multiple);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(deliveryTag + " : failed");
            }
        });


    }
}
