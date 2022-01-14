package com.tdh.springcloud.service;

import com.tdh.springcloud.entitys.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Integer id);
}
