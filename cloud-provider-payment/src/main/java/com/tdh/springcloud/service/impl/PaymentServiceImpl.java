package com.tdh.springcloud.service.impl;

import com.tdh.springcloud.dao.PaymentDao;
import com.tdh.springcloud.entitys.Payment;
import com.tdh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
         return paymentDao.getPaymentById(id);
    }
}
