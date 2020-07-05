package com.amber.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author: Amber
 */
@Service
public class ConsumerService_02 {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "boot-sc")
    public void revice(TextMessage message) {
        try {
            System.out.println("消费者2收到订阅消息 " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
