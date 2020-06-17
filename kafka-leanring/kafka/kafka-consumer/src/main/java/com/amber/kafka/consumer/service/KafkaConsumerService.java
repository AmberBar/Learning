package com.amber.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerService {

    /**
     * 单条数据消费
     * @param record
     * @param acknowledgment
     * @param consumer
     */
    @KafkaListener(groupId = "amber-group", topics = "amber-topic")
    public void message(ConsumerRecord<String, Object> record,
                        Acknowledgment acknowledgment,
                        Consumer<?, ?> consumer) {
        log.info("消费端接受消息 {}" , record.value());
        Object value = record.value();
        // 应答
        acknowledgment.acknowledge();
    }
}
