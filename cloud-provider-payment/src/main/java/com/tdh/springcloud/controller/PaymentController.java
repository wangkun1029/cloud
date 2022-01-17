package com.tdh.springcloud.controller;

import com.tdh.springcloud.entitys.CommonResult;
import com.tdh.springcloud.entitys.Payment;
import com.tdh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, result);
        }else{
            return  new CommonResult(500,"查询成功",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        for (String element : list) {
            log.info("***element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + "ip:" + instance.getHost() + ":" + instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
