package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Author: Amber
 */
public class ConsumberListener {
    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_01";
    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue(QUEUE_NAME));
//        consumer.setMessageListener(new MessageListener() {
//
//            @SneakyThrows
//            @Override
//            public void onMessage(Message message) {
//                TextMessage textMessage = (TextMessage) message;
//                String text = textMessage.getText();
//                System.out.println("消费者.... " + text);
//            }
//        });

        consumer.setMessageListener((Message message)-> {
            TextMessage textMessage = (TextMessage) message;
            String text = null;
            try {
                text = textMessage.getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println("消费者.... " + text);
        });

        System.in.read();
    }
}
