package com.fill.filestorage.service.impl;

import com.fill.filestorage.command.SaveFileToDiskCommand;
import com.fill.filestorage.service.FileStorageExecutorStrategy;
import com.fill.filestorage.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import java.io.InputStream;
import java.util.Map;

@Service(value = "fileStorageService")
public class FileStorageServiceImpl implements FileStorageService, InitializingBean {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private Map<String, FileStorageExecutorStrategy> executorStrategyMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notEmpty(executorStrategyMap, "文件存储策略为空....");
    }

    @Override
    public String uploadByStream(String systemId, String businessId, String type, InputStream inputStream) {
        if (!executorStrategyMap.containsKey(type)) {
            logger.error("不包含对应的存储策略服务，存储策略:{}", type);
        }
        String key = systemId + "-" + businessId;
        int code = key.hashCode();
        StopWatch watch = new StopWatch("FileStorageExecutor");
        watch.start("storage");
        FileStorageExecutorStrategy executor = executorStrategyMap.get(type);
        String result = new SaveFileToDiskCommand(executor, code, inputStream).execute();
        logger.debug("execute result:{}", result);
        watch.stop();
        logger.debug(watch.prettyPrint());
        return result;
    }
}
