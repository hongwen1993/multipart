package com.kagura.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kagura.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/16 16:52
 * @since 1.0.0
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        //log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        System.err.println("message : " + gson.toJson(message));
        kafkaTemplate.send("test01", gson.toJson(message));
    }

}
