package com.cloud.nacospayment.controller;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "nacos registry,serverPort:" + serverPort + "\t id:" + id;
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id) {
        CommonResult<Payment> commonResult = null;
        Payment payment = new Payment();
        if(id ==1){
            commonResult = new CommonResult<>();
            payment.setId(1);
            payment.setSerial("wallace");
        }
        commonResult.setData(payment);
        return commonResult;
    }
}
