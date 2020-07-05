package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Author: Amber
 */
public class ConsumberTransaction {
    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_acknowledge";

    /**
     * 事务关闭:
     * 1. Session.AUTO_ACKNOWLEDGE 成功消费
     * 2. Session.CLIENT_ACKNOWLEDGE 没有成功消费，当下次重启的时候，还会进行消费,
     * 配合 textMessage.acknowledge()成功消费
     * @param args
     * @throws JMSException
     * @throws IOException
     */
    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue(QUEUE_NAME));

        consumer.setMessageListener((Message message)-> {
            TextMessage textMessage = (TextMessage) message;
            String text = null;
            try {
                text = textMessage.getText();
                textMessage.acknowledge();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println("消费者.... " + text);
        });

        System.in.read();
    }
}
