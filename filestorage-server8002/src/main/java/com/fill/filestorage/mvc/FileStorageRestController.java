package com.fill.filestorage.mvc;

import com.fill.filestorage.service.FileStorageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

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


    @Autowired
    private FileStorageService fileStorageService;



    @GetMapping(value = "/ping")
    @ApiOperation(value = "当前微服务状态", notes = "返回200表示当前微服务已启动")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功")
    })
    public String ping() {
        logger.debug("ping filestorage-server....");
        return "200, port:" + port;
    }


    @PostMapping(value = "/storage/{systemId}/{businessId}")
    @ApiOperation(value = "以流的形式存储文件内容")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "以流的形式存储文件内容成功")
    })
    public String save(
        @PathVariable(value = "systemId") String systemId,
        @PathVariable(value = "businessId") String businessId,
        @RequestParam(value = "inputStream", required = false)InputStream inputStream) {

        fileStorageService.uploadByStream(systemId, businessId, null, inputStream);
        return "";
    }


    @GetMapping(value = "/hystrix")
    @ApiOperation(value = "服务降级熔断的demo方法")
    @HystrixCommand(fallbackMethod = "hystrix", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hystrixDemo() {
        try {
            Thread.sleep(2000);
//            int value = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }


    public String hystrix() {
        return "hystrix....";
    }


}
