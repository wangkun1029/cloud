package com.tdh.springcloud.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    /**
     * ribbon 负载均衡规则替换
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
