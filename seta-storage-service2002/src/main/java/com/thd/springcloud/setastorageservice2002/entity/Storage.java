package com.thd.springcloud.setastorageservice2002.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Integer id;


    private Integer productId;

    private Integer total;

    private Integer used;

    private Integer residue;



}
