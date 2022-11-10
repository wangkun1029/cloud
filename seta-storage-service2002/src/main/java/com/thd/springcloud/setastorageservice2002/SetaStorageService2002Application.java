package com.thd.springcloud.setastorageservice2002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SetaStorageService2002Application {

    public static void main(String[] args) {
        SpringApplication.run(SetaStorageService2002Application.class, args);
    }

}
