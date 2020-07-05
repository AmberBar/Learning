ActiveMQ小案例
producer:
```
 // 1. 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        // 2. 建立连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        
        // 3. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4. 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);
		// 5. 创建生产者
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("amber ...Test " + i);
            producer.send(textMessage);
        }
        System.out.println("producer 发送成功");
		// 6 关闭资源
        producer.close();
        session.close();
        connection.close();
```

consumber小例子
```
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
```

消费者使用监听器监听消息
```java

ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(session.createQueue(QUEUE_NAME));
        consumer.setMessageListener(new MessageListener() {

            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("消费者.... " + text);
            }
        });

        System.in.read();
```