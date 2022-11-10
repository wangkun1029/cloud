package com.tdh.springcloud.setaorderservice2001.dao;

import com.tdh.springcloud.setaorderservice2001.entitys.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDaoMapper {


    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    void update(@Param("userId") Integer userId,@Param("status") Integer status);
}
