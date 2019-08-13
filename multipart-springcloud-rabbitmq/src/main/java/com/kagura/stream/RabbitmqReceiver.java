package com.kagura.stream;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/13 18:02
 * @since 1.0.0
 */
@EnableBinding(Barista.class)
@Service
public class RabbitmqReceiver {

    @StreamListener(Barista.INPUT_CHANNEL)
    public void receiverMessage(Message message) throws IOException {
        System.err.println("接收消息：" + message.getPayload());
        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        if(deliveryTag != null) {
            channel.basicAck(deliveryTag, false);
        }
    }
}
