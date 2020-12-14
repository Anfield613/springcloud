package com.fill.config.ribbon;

import com.fill.apps.config.ribbon.CustomRibbonRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomRibbonConfiguration {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public CustomRibbonRule ribbonRule() {
        return new CustomRibbonRule();
    }
}
