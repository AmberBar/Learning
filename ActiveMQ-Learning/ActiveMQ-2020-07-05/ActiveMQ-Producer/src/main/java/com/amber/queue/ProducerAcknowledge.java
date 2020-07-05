package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Amber
 */
public class ProducerAcknowledge {

    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_acknowledge";

    /**
     * 对于生产者而言
     * 事务未开启:
     * 1. Session.CLIENT_ACKNOWLEDGE 会发送到队列
     * 2. Session.AUTO_ACKNOWLEDGE YES
     * 事务开启:
     * 1. 没有commit 消息不会发送成功
     * @param args
     * @throws JMSException
     */
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        // 开启事务
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("amber ...Test " + i);
            producer.send(textMessage);
        }
        System.out.println("producer 发送成功");
        // 如果没有commit,消息发送不成功
        producer.close();
        session.close();
        connection.close();
    }
}
