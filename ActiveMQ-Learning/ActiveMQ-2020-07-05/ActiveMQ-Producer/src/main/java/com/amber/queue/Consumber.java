package com.amber.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @Author: Amber
 */
public class Consumber {
    private static final String url = "tcp://192.168.40.144:61616";

    private static final String QUEUE_NAME = "producer_01";

    public static void main(String[] args) throws JMSException, IOException {
        // 1. 建立连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        // 2. 建立连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 3. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 4. 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5. 创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        while (true){
            //记住：发送的是什么格式，自然接收的格式也要跟发送的格式一样
            // TextMessage textMessage =(TextMessage) messageConsumer.receive(); //不带时间的receive()方法，说明这方法一直在等待新消息。
            TextMessage textMessage =(TextMessage) consumer.receive(4000L);  //带时间的receive()方法，说明该方法一旦到了时间就立刻结束接收。
            if (null != textMessage){
                System.out.println("****消费者接收到消息:"+textMessage.getText());
            }else {
                break;
            }
        }

        // 6. 关闭资源
        consumer.close();
        session.close();
        connection.close();

    }
}
