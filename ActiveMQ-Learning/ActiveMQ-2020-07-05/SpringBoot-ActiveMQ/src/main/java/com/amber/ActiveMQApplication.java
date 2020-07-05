package com.amber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Amber
 */
@SpringBootApplication
@EnableJms
public class ActiveMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveMQApplication.class, args);
    }
}
