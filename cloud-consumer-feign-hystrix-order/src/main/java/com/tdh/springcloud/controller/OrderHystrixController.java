package com.tdh.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tdh.springcloud.exception.GlobalException;
import com.tdh.springcloud.payment.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackHandler")
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/get/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo(id);
        log.info("result",result);
        return result;
    }


    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")})
    @HystrixCommand(commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="1500")})
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info("result",result);
        return result;
    }

    //自定义的异常处理
    public String paymentInfoTimeOutFallbackHandler(@PathVariable("id") Integer id){
        return "我是消费，对方系统服务繁忙，请稍后再试";
    }


    //全局异常处理
    public String globalFallbackHandler(){
       return new GlobalException().globalFallbackHandler();
    }

}
