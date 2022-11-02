package com.thd.springcloud.cloudopenfeignorder.service;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {
        return new CommonResult<>(4444,"服务降级返回",new Payment(id,"error"));
    }
}
