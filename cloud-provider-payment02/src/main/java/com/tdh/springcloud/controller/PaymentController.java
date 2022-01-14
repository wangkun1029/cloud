package com.tdh.springcloud.controller;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import com.tdh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult  create(Payment payment){
       int result = paymentService.create(payment);
       if(result > 0){
           return  new CommonResult(200,"插入成功,serverPort:"+serverPort);
       }else{
           return  new CommonResult(500,"插入失败");
       }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult  getPaymentById(@PathVariable("id") Integer id){
        Payment result = paymentService.getPaymentById(id);
        if(null != result){
            return  new CommonResult(200, "查询成功,serverPort:" + serverPort, result);
        }else{
            return  new CommonResult(500,"查询成功",null);
        }
    }
}
