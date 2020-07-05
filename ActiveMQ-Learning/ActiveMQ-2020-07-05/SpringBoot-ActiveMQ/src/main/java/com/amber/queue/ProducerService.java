package com.amber.queue;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;


import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * 问题: JmsTemplate  JmsMessagingTemplate 的区别
 * 猜想，JmsTemplate是spring的，JmsMessagingTemplate是Spring Boot的
 * 使用JmsTemplate发送延迟消息
 * @Author: Amber
 */
@Service
public class ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message, long delay) {

//        jmsTemplate.convertAndSend("boot-produce", message,
//                new MessagePostProcessor() {
//                    @Override
//                    public Message postProcessMessage(Message message) throws JMSException {
//                        message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
//                        return message;
//                    }
//                });

        jmsTemplate.convertAndSend("boot-sc", message,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws JMSException {
                        message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
                        return message;
                    }
                });
    }
}
