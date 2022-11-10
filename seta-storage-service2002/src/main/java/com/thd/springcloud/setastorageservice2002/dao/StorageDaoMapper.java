package com.thd.springcloud.setastorageservice2002.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface  StorageDaoMapper {



    void decrease(@Param("productId") Integer productId,@Param("count") Integer count);
}
