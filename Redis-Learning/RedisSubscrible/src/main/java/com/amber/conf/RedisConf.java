package com.amber.conf;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.amber.receiver.AmberReceiver;
import com.amber.receiver.TestReceiver;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: Amber
 */
@Configuration
public class RedisConf {

    /**
     * 配置其他类型的redisTemplate
     ***/
    @Bean
    public RedisTemplate<String, Object> redisTemplateKeyObject(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory,
                                            MessageListenerAdapter amberAdapt,
                                            MessageListenerAdapter testAdapt) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(amberAdapt, new PatternTopic("amber"));
        redisMessageListenerContainer.addMessageListener(testAdapt, new PatternTopic("test"));
        return redisMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter amberAdapt(AmberReceiver amberReceiver) {
        return new MessageListenerAdapter(amberReceiver, "receiverMessage");
    }

    @Bean
    MessageListenerAdapter testAdapt(TestReceiver testReceiver) {
        return new MessageListenerAdapter(testReceiver, "receiverMessage");
    }

    @Bean
    AmberReceiver amberReceiver() {
        return new AmberReceiver();
    }

    @Bean
    TestReceiver testReceiver() {
        return new TestReceiver();
    }
}
