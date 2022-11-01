package com.thd.springcloud.cloudnacosgroupconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudNacosGroupConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosGroupConfigApplication.class, args);
    }

}
