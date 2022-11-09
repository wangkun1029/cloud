package com.tdh.springcloud.setaorderservice2001.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private Integer userId;

    private Integer count;

    private Integer productId;

    private Integer status;

    private BigDecimal money;


}
