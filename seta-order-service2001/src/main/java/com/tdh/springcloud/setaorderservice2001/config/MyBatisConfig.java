package com.tdh.springcloud.setaorderservice2001.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.tdh.springcloud.setaorderservice2001.dao"})
public class MyBatisConfig {

}
