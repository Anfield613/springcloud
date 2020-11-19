package com.fill.ribbon.config;


import com.fill.springcloud.ribbon.rule.CustomRibbonRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuleConfiguration {


    @Bean
    public IRule rule() {
        return new CustomRibbonRule();
    }
}
