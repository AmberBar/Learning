package com.amber.kafka.producer.servic;

import com.amber.kafka.producer.ProducerApplication;
import com.amber.kafka.producer.service.KafkaProducerService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class KafkaProducerServiceTest extends TestCase {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @Test
    public void test() {
        kafkaProducerService.sendMessage("amber-topic", "amber");
    }
}