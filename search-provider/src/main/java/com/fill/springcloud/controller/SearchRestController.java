package com.fill.springcloud.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(tags = "搜索服务")
@RestController
public class SearchRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String serviceName;


    @ApiOperation(value = "ping搜索微服务", tags = "搜索服务")
    @GetMapping(value = "/ping")
    public String pingSearchProvider() {
        return serviceName + ":" + UUID.randomUUID().toString();
    }
}
