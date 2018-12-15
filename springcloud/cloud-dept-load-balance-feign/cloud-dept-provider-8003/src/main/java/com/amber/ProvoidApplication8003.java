package com.amber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProvoidApplication8003 {

    public static void main(String[] args) {
        SpringApplication.run(ProvoidApplication8003.class, args);
    }
}
