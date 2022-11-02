package com.thd.springcloud.cloudopenfeignorder.controller;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import com.thd.springcloud.cloudopenfeignorder.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id){
      return   paymentService.paymentSQL(id);
    };
}
