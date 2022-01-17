package com.tdh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo(Integer id){
        return "success";
    }


    //服务降级有个兜底的方法
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String paymentInfoTimeOut(Integer id){
        int second = 3;
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是延时的服务,耗时 "+second;
    }

    public String paymentInfoTimeOutHandler(Integer id){
        return "线程池 "+ Thread.currentThread().getName()+" 服务器繁忙，请稍后再试";
    }
}
