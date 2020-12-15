/*
 * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved.
 * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.fill.filestorage.service;

import java.io.InputStream;

/**
 * <p>
 * 文件存储执行策略服务接口
 * @author <a href="mailto:fangzz@smartdot.com.cn">fangzizhong</a>
 * @version 1.0, 2020-12-15
 */
public interface FileStorageExecutorStrategy {


    /**
     * 保存文件
     * @param code 通过业务数据id以及所属系统标识计算出的code值，code值主要用来计算文件存储位置
     * @param inputStream 待存储的文件的流信息
     * @return 在文件存储系统中的唯一标示
     */
    public String save(int code, InputStream inputStream);

}
