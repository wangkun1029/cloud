package com.tdh.springcloud.controller;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

//    public static final String pay_url ="http://localhost:8001";
    //从eureka上获取机器访问地址
    public static final  String pay_url ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/cosumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(pay_url+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/cosumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id){
        return restTemplate.getForObject(pay_url+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping("/cosumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Integer id){
        ResponseEntity<CommonResult> response = restTemplate.getForEntity(pay_url+"/payment/get/"+id,CommonResult.class);
        if(response.getStatusCode().is2xxSuccessful()){
          return response.getBody();
        }else {
            return new CommonResult<>(500,"查询失败");
        }
    }
}
