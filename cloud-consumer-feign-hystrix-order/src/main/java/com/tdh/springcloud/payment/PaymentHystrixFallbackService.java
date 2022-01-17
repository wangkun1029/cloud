package com.tdh.springcloud.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{
    //针对每一个接口实现服务降级
    @Override
    public String paymentInfo(Integer id) {
        return "PaymentHystrixFallbackService-----fallback---paymentInfo";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentHystrixFallbackService----fallback---paymentInfoTimeOut";
    }
}
