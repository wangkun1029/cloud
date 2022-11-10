package com.thd.springcloud.setastorageservice2002.controller;


import com.thd.springcloud.setastorageservice2002.entity.CommonResult;
import com.thd.springcloud.setastorageservice2002.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping(value = "/storage/decrease")
    private CommonResult create(Integer productId, Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200, "库存扣减成功");
    }

}
