package com.amber.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Author: Amber
 */
public class Consumber_02 {
    private static final String url = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_topic";

    public static void main(String[] args) throws JMSException, IOException {
        // 1. 建立连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        // 2. 建立连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建目的地
        Topic topic = session.createTopic(QUEUE_NAME);
        // 5. 创建消费者
        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("消费者接受消息 " + text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
        System.in.read();
        // 6. 关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
