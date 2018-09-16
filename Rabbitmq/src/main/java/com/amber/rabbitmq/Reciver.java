package com.amber.rabbitmq;

import com.amber.Contains;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Reciver  {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitHandler
    @RabbitListener(queues = Contains.DIRECT_QUEUQ)
    public void directRevicer(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
/*        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
            System.out.println(  simpleDateFormat.format(new Date()) + "   " + message);
            System.out.println(message);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }*/


        System.out.println("Receiver : " +  message);
        System.out.println(channel);
        System.out.println(message.getMessageProperties().getDeliveryTag());
        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RabbitHandler
    @RabbitListener(queues = Contains.DELAY_X_QUEUE)
    public void delayXRevicer(String message) {
        System.out.println("this is delay x queue:   " +  message);
    }


}
