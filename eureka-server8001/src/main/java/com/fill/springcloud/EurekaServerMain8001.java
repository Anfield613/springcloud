package com.fill.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain8001 {


    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain8001.class, args);
    }
}