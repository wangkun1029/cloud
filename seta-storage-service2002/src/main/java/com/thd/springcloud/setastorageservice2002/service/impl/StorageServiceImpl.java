package com.thd.springcloud.setastorageservice2002.service.impl;

import com.thd.springcloud.setastorageservice2002.dao.StorageDaoMapper;
import com.thd.springcloud.setastorageservice2002.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDaoMapper storageDaoMapper;

    @Override
    public void decrease(Integer productId, Integer count) {
        log.info("开始扣减库存了，count={}",count);
        //测试全局事务问题
//        Time.sleep(20);
        storageDaoMapper.decrease(productId,count);
        log.info("扣减库存成功了！");
    }
}
