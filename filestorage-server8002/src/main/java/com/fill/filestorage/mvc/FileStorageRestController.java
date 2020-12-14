package com.fill.filestorage.mvc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author <a href="mailto:coderFill@hotmail.com">coderFill</a>
 * @version 1.0, 2020-12-04
 */
@Api(tags = "文件存储微服务")
@RestController("fileStorageRestController")
public class FileStorageRestController {

    private final Logger logger = LoggerFactory.getLogger(FileStorageRestController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping(value = "/ping")
    @ApiOperation(value = "当前微服务状态", notes = "返回200表示当前微服务已启动")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public String ping() {
        logger.debug("ping filestorage-server....");
        return "200, port:" + port;
    }


}
