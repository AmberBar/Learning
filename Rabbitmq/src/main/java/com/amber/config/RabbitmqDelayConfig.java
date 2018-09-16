package com.amber.config;

import com.amber.Contains;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqDelayConfig {

    @Bean
    public Queue delayXQueue() {
        return new Queue(Contains.DELAY_X_QUEUE, true);
    }

    @Bean
    CustomExchange delayXExchange() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(Contains.DELAY_X_EXCHANGE, "x-delayed-message", true, false, args);
    }

    @Bean
    Binding delayXExchangeBinding(Queue delayXQueue, Exchange delayXExchange) {
        return BindingBuilder.bind(delayXQueue()).to(delayXExchange()).with(Contains.DELAY_X_QUEUE).noargs();
    }

    @Bean
    public Queue delayQueue() {
        Map<String, Object> params = new HashMap<String, Object>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", Contains.DIRECT_EXCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", Contains.DIRECT_QUEUQ);
        return new Queue(Contains.DELAY_QUEUE, true, false, false, params);
    }

    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(Contains.DELAY_EXCHANGE);
    }

    @Bean
    public Binding delayExchangeBinding(Queue delayQueue, DirectExchange delayExchange) {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(Contains.DELAY_QUEUE);
    }

}
