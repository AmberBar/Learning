package com.amber.controller;

import com.amber.Contains;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/rabbitmq")
public class Rabbitmq {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/directSender")
    public void sender() {
        this.rabbitTemplate.convertAndSend(Contains.DIRECT_EXCHANGE, Contains.DIRECT_QUEUQ, "beauty");
    }

    @GetMapping("/delayXSender")
    public void delayXSender() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        final int delayMilliSeconds = 5000;
        final String date = simpleDateFormat.format(new Date());
        //给消息设置TTL
        this.rabbitTemplate.convertAndSend(Contains.DELAY_X_EXCHANGE, Contains.DELAY_X_QUEUE, "this is x delay message -------:" + delayMilliSeconds,
                new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        System.out.println("设置延迟时间： " + delayMilliSeconds + "now :" + date);
                        message.getMessageProperties().setDelay((int)delayMilliSeconds);
                        return message;
                    }
                });
    }


    @GetMapping("/delaySender")
    public void delaySender() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:mm:dd hh:mm:ss");
        final String date = simpleDateFormat.format(new Date());
        //给消息设置TTL
        this.rabbitTemplate.convertAndSend(Contains.DELAY_EXCHANGE, Contains.DELAY_QUEUE, "this is delay message -------:" + date,
            new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setExpiration("5000");
                    return message;
                }
            });
    }


}
