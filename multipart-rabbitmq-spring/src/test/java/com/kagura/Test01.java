package com.kagura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8 15:53
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public void testRabbitAdmin() {
        rabbitAdmin.declareExchange(new DirectExchange("test.direct.exchange", true, false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic.exchange", true, false));
        rabbitAdmin.declareQueue(new Queue("test.direct.queue", true, false, false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue", true, false, false));
        rabbitAdmin.declareBinding(new Binding("test.direct.queue", Binding.DestinationType.QUEUE,
                "test.direct.exchange", "test.direct.key", new HashMap<>()));
        rabbitAdmin.declareBinding(BindingBuilder
                .bind(new Queue("test.topic.queue", true, false, false))
                .to(new TopicExchange("test.topic.exchange", true, false))
                .with("test.topic.#"));
    }

}
