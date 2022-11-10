package com.tdh.springcloud.setaorderservice2001.service.impl;

import com.tdh.springcloud.setaorderservice2001.dao.OrderDaoMapper;
import com.tdh.springcloud.setaorderservice2001.entitys.Order;
import com.tdh.springcloud.setaorderservice2001.service.AccountService;
import com.tdh.springcloud.setaorderservice2001.service.OrderService;
import com.tdh.springcloud.setaorderservice2001.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDaoMapper orderDaoMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    // 全局事务回滚
    @GlobalTransactional(name = "create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始新建订单");
        orderDaoMapper.create(order);

        log.info("订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("订单微服务开始调用库存，做扣减end");

        log.info("订单微服务开始调用账户");
        //accountService.decrease(order.getUserId(),order.getMoney());
        log.info("订单微服务开始调用账户end");

        log.info("开始修改订单状态");
        orderDaoMapper.update(order.getUserId(), 1);
        log.info("开始修改订单状态end");

        log.info("订单处理成功");



    }
}
