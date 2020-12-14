package com.fill.apps.mvc;


import com.fill.apps.client.FileStorageFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "应用系统")
@RestController
public class AppsRestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private FileStorageFeignClient fileStorageFeignClient;



    @GetMapping("/filestorage")
    @ApiOperation(value = "检测文件存储服务是否启动", tags = "应用系统")
    public String fileStorageServerIsReady() {
        return fileStorageFeignClient.ping();
    }

}
