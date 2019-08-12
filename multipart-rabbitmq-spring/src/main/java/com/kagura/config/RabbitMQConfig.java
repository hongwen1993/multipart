package com.kagura.config;


import com.rabbitmq.client.impl.AMQImpl;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/8 13:57
 * @since 1.0.0
 */
@Configuration
@ComponentScan({"com.kagura.*"})
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("192.168.66.66:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean
    @DependsOn({"binding001", "binding002"})
    public RabbitAdmin rabbitAdmin(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        System.err.println(222222);
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }


    @Bean
    public TopicExchange exchange001() {
        System.err.println(111111);
        return new TopicExchange("test.bean.topic.exchange001", true, false);
    }

    @Bean
    public Queue queue001() {
        System.err.println(111111);
        return new Queue("test.bean.topic.queue001", true, false, false);
    }

    @Bean
    public Queue queue002() {
        System.err.println(111111);
        return new Queue("test.bean.topic.queue002", true, false, false);
    }

    @Bean
    public Binding binding001(@Qualifier("queue001") Queue queue001,
                              @Qualifier("exchange001") TopicExchange exchange001) {
        System.err.println(111111);
        return BindingBuilder.bind(queue001).to(exchange001).with("test.01.#");
    }

    @Bean
    public Binding binding002(@Qualifier("queue002") Queue queue002,
                              @Qualifier("exchange001") TopicExchange exchange001) {
        System.err.println(111111);
        return BindingBuilder.bind(queue002).to(exchange001).with("test.02.#");
    }


    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(
            @Qualifier("connectionFactory") ConnectionFactory connectionFactory,
            @Qualifier("queue001") Queue queue001, @Qualifier("queue002") Queue queue002) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.addQueues(queue001, queue002);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(3);

        return null;
    }


}
