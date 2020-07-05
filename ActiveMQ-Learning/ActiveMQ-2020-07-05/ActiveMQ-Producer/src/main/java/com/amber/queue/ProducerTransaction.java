package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: Amber
 */
public class ProducerTransaction {

    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_transaction";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
//        // 关闭事务
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = session.createQueue(QUEUE_NAME);
//        MessageProducer producer = session.createProducer(queue);
//
//        for (int i = 0; i < 3; i++) {
//            TextMessage textMessage = session.createTextMessage();
//            textMessage.setText("amber ...Test " + i);
//            producer.send(textMessage);
//        }
//        System.out.println("producer 发送成功");
//        producer.close();
//        session.close();
//        connection.close();

        // 开启事务
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("amber ...Test " + i);
            producer.send(textMessage);
        }
        System.out.println("producer 发送成功");
        // 如果没有commit,消息发送不成功
        session.commit();
        producer.close();
        session.close();
        connection.close();
    }
}
