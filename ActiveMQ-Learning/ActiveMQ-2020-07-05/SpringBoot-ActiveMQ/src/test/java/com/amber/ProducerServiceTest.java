package com.amber;

import com.amber.queue.ConsumerService;
import com.amber.queue.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Amber
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerServiceTest {

    @Autowired
    ProducerService producerService;

    @Test
    public void send() {
        producerService.sendMessage("amber this is boot", 10000L);
    }

    @Test
    public void sendDelay() {
        producerService.sendMessage("我是延迟消息1", 15000L);
        producerService.sendMessage("我是延迟消息2", 10000L);
    }
}
