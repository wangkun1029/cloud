package com.cloud.nacospayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentApplication.class, args);
    }

}