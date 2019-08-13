package kagura.producer;


import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/13 14:33
 * @since 1.0.0
 */
@Component
public class RabbitSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        System.err.println(correlationData);
        System.err.println(ack);
        if(!ack) {
            System.err.println("error handler ");
        }
    };

    private final RabbitTemplate.ReturnCallback returnCallback = (message, replyCode, replyText,
                                                                  exchange, routingKey) -> {
        System.err.println(message);
        System.err.println(replyCode);
        System.err.println(replyText);
        System.err.println(exchange);
        System.err.println(routingKey);
    };

    public void send(Object message, Map<String, Object> properties) {
        MessageHeaders headers = new MessageHeaders(properties);
        Message ms = MessageBuilder.createMessage(message, headers);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData correlationData = new CorrelationData(System.currentTimeMillis() + "112556");
        rabbitTemplate.convertAndSend("test.topic.exchange", "save.user", ms, correlationData);
    }

}
