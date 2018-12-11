package com.amber.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //默认是论循
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    /**
//     * 重写IRule替换掉默认算法
//     * @return
//     */
//    @Bean
//    public IRule iRule(){
//        //随机
////        return new RandomRule();
//        //重试,在provide没有出错的时候就是轮循算法，出错几次后，就不会再访问这个provide
//        return new RetryRule();
//    }

}
