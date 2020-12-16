/*
 * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fill.filestorage.command;

import com.fill.filestorage.service.FileStorageExecutorStrategy;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;

/**
 * <p>
 * 通过{@link HystrixCommand}包装的磁盘存储命令
 * @author <a href="mailto:fangzz@smartdot.com.cn">fangzizhong</a>
 * @version 1.0, 2020-12-15
 */
public class SaveFileToDiskCommand extends HystrixCommand<String> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private FileStorageExecutorStrategy executor;
    private int code;
    private InputStream inputStream;

    public SaveFileToDiskCommand(FileStorageExecutorStrategy executor, int code, InputStream inputStream) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("fileStorageExecutor"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("saveToDisk"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerEnabled(true)
                .withCircuitBreakerErrorThresholdPercentage(60)
                .withCircuitBreakerRequestVolumeThreshold(20)
                .withCircuitBreakerSleepWindowInMilliseconds(20000)
                .withExecutionTimeoutEnabled(true))
            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
        this.executor = executor;
        this.code = code;
        this.inputStream = inputStream;
    }

    @Override
    protected String run() throws Exception {
        logger.debug("executor by:{}", getClass());
        return executor.save(code, inputStream);
    }

    @Override
    protected String getFallback() {
        logger.error("fallback, return:{}", "");
        return "";
    }
}
