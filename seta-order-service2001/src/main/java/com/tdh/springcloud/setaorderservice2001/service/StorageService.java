package com.tdh.springcloud.setaorderservice2001.service;

import com.tdh.springcloud.setaorderservice2001.entitys.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
