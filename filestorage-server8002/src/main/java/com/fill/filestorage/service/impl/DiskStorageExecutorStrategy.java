/*
 * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fill.filestorage.service.impl;

import com.fill.filestorage.command.SaveFileToDiskCommand;
import com.fill.filestorage.service.FileStorageExecutorStrategy;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 磁盘存储策略的实现
 * @author <a href="mailto:fangzz@smartdot.com.cn">fangzizhong</a>
 * @version 1.0, 2020-12-15
 */
@Service(value = "disk")
public class DiskStorageExecutorStrategy implements FileStorageExecutorStrategy, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public String save(int code, InputStream inputStream) {
        String md5 = null;
        try {
            md5 = createMd5Code(inputStream);
            logger.debug("create file md5 code:{}", md5);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    /**
     * 生辰文件的md5码
     * @param inputStream
     * @return
     * @throws IOException
     */
    protected String createMd5Code(InputStream inputStream) throws IOException {
        return DigestUtils.md5Hex(inputStream);
    }
}
