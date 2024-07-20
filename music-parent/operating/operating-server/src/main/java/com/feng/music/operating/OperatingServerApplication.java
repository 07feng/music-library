package com.feng.music.operating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.feng.music.operating", "com.feng.music.common"})
public class OperatingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatingServerApplication.class, args);
    }

}
