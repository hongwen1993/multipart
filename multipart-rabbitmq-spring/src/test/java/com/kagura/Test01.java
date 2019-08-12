package com.kagura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test01() {
        MessageProperties properties = new MessageProperties();
        properties.getHeaders().put("desc", "信息描述..");
        properties.getHeaders().put("type", "自定义消息类型..");
        Message message = new Message("Test Message ".getBytes(), properties);
        rabbitTemplate.convertAndSend("test.bean.topic.exchange001", "test.01.666", message,
                message1 -> {
            // 发送之前会调用以下方法, 并重新返回一个指定的Message
            System.err.println("------添加额外的设置---------");
            message.getMessageProperties().getHeaders().put("desc", "额外修改的信息描述");
            message.getMessageProperties().getHeaders().put("attr", "额外新加的属性");
            return message;
        });
    }

    @Test
    public void testSendMessage2() throws Exception {
        //1 创建消息
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        Message message = new Message("mq 消息1234".getBytes(), messageProperties);
        // send方法可以添加Properties
        rabbitTemplate.send("test.bean.topic.exchange001", "test.01.1", message);


        rabbitTemplate.convertAndSend("test.bean.topic.exchange001", "test.01.1", "hello object message send!");
        rabbitTemplate.convertAndSend("test.bean.topic.exchange001", "test.02.#", "hello object message send!");
    }






}
