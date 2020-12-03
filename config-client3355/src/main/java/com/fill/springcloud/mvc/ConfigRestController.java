/*
 * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fill.springcloud.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author <a href="mailto:fangzz@smartdot.com.cn">fangzizhong</a>
 * @version 1.0, 2020-11-26
 */
@RestController("configRestController")
public class ConfigRestController {

    @Value("${config.info.version}")
    private String configVersion;

    @Value("${config.info.name}")
    private String configName;

    @GetMapping("/version")
    public String getVersion() {
        return "name:" + configName + ", version:" + configVersion;
    }
}
