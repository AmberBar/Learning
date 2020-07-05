package com.amber.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.format.datetime.DateFormatter;

import javax.jms.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: Amber
 */
public class Producer {

    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_topic";

    public static void main(String[] args) throws JMSException {
        // 1. 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 建立连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        
        // 3. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4. 创建目的地
        Topic topic = session.createTopic(QUEUE_NAME);

        // 5. 创建生产者
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage();
            /**
             * 消息头:
             * JMSMessageID
             *
             */
            textMessage.setJMSMessageID(UUID.randomUUID().toString());

            textMessage.setText("amber ...Test " + new Date().getMinutes());
            producer.send(textMessage);
        }
        System.out.println("producer 发送成功");
        producer.close();
        session.close();
        connection.close();
    }
}
