package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;

/**
 * @Author: Amber
 */
public class Producer {

    private static final String URL = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_01";

    public static void main(String[] args) throws JMSException {
        // 1. 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 建立连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 3. 启动
        connection.start();
        
        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 5. 创建生产者
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 5000L);
            textMessage.setText("amber ...Test " + i);
            producer.send(textMessage);
        }
        System.out.println("producer 发送成功");
        producer.close();
        session.close();
        connection.close();
    }
}
