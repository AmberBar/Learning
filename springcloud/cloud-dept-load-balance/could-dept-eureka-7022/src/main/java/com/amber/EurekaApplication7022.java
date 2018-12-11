package com.amber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication7022 {

    public static void main(String[] args){
        SpringApplication.run(EurekaApplication7022.class, args);
    }
}
