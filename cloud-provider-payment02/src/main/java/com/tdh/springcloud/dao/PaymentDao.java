 package com.tdh.springcloud.dao;

import com.tdh.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

 @Mapper
 public interface PaymentDao {

     public int create(Payment payment);

     public Payment getPaymentById(@Param("id") Integer id);

 }
