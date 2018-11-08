package com.beiyi.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息生产者
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "Hello, beiyi. It is " + new Date();
        amqpTemplate.convertAndSend("beiyi",context);
    }
}
