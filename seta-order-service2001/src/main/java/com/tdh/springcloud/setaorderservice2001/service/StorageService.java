package com.tdh.springcloud.setaorderservice2001.service;

import com.tdh.springcloud.setaorderservice2001.entitys.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seta-storage-service")
public interface StorageService {

    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
