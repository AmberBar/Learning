package com.amber.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ConsumerDept9001 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerDept9001.class, args);
    }
}
