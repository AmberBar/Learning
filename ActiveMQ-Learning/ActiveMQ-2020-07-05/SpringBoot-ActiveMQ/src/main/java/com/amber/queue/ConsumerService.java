package com.amber.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Author: Amber
 */
@Service
public class ConsumerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "boot-produce")
    public void revice(TextMessage message) {
        try {
            System.out.println("消费者接受到消息 " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
