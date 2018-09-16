package com.amber.config;

import com.amber.Contains;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqDirectConfig {

    @Bean
    public Queue directQueue() {
        return new Queue(Contains.DIRECT_QUEUQ, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(Contains.DIRECT_EXCHANGE,true, false);
    }

    @Bean
    public Binding binding(Queue directQueue, DirectExchange directExchange) {
        //with(ROUTING_KEY) 路由的key值可以随意填写，这里为了方便就和队列名一样了
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(Contains.DIRECT_QUEUQ);
    }
}
