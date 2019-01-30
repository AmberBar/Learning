package com.amber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProvoidApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProvoidApplication8001.class, args);
    }
}
