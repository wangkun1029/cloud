package com.tdh.springcloud.setaorderservice2001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SetaOrderService2001Application {

    public static void main(String[] args) {
        SpringApplication.run(SetaOrderService2001Application.class, args);
    }

}
