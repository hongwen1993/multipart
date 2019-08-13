package kagura.consumer;

import com.rabbitmq.client.Channel;
import kagura.entity.User;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 消费者
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/13 15:47
 * @since 1.0.0
 */
@Component
public class RabbitReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-01", durable = "true"),
            exchange = @Exchange(value = "topic.exchange-01", durable = "true",
                    type = "topic", ignoreDeclarationExceptions = "true"),
            key = "save.#"
    ))
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws IOException {
        Object object = message.getPayload();
        System.out.println("receiver message : " + object);
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        if(deliveryTag != null) {
            channel.basicAck(deliveryTag, false);
        }
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${spring.rabbitmq.queue.name}",
                    durable = "${spring.rabbitmq.queue.durable}"),
            exchange = @Exchange(value = "${spring.rabbitmq.exchange.name}",
                    durable = "${spring.rabbitmq.exchange.durable}",
                    type = "${spring.rabbitmq.exchange.type}",
                    ignoreDeclarationExceptions = "${spring.rabbitmq.exchange.ignoreDeclarationExceptions}"),
            key = "${spring.rabbitmq.key}"
    ))
    @RabbitHandler
    public void onMessage2(@Payload User user, @Headers Map<String, Object> headers,
                           Channel channel) throws IOException {
        System.out.println("receiver message : " + user);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        if (deliveryTag != null) {
            channel.basicAck(deliveryTag, false);
        }
    }

}
