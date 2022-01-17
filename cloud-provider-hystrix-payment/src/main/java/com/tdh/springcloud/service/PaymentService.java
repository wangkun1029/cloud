package com.tdh.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo(Integer id){
        return "success";
    }


    public String paymentInfoTimeOut(Integer id){
        int second = 3;
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务出错了,耗时 "+second;
    }
}
