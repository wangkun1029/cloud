package com.tdh.springcloud.setaorderservice2001.controller;

import com.tdh.springcloud.setaorderservice2001.entitys.CommonResult;
import com.tdh.springcloud.setaorderservice2001.entitys.Order;
import com.tdh.springcloud.setaorderservice2001.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    private CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
