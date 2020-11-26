/*
 * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.fill.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * @author <a href="mailto:fangzz@smartdot.com.cn">fangzizhong</a>
 * @version 1.0, 2020-11-26
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
