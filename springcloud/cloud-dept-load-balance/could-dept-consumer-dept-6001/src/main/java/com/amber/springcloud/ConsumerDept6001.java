package com.amber.springcloud;

import com.amber.MyIrule.MyIrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RibbonClient(name = "COULD-DEPT-PROVIDE-DEPT", configuration = MyIrule.class)
public class ConsumerDept6001 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerDept6001.class, args);
    }
}
