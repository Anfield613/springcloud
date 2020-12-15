package com.fill.filestorage.service;

import java.io.InputStream;

public interface FileStorageService {


    /**
     * 以文件流的形式上传文件
     * @param systemId 所属业务系统的id
     * @param businessId 业务数据id，在所属业务系统中的唯一标示
     * @param type 存储方式，以磁盘存储或者以数据库存储
     * @param inputStream {@link InputStream}形式的，待存储的文件
     * @return
     */
    public String uploadByStream(String systemId, String businessId, String type, InputStream inputStream);
}
