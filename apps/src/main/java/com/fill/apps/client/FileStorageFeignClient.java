package com.fill.apps.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "filestorage-server")
public interface FileStorageFeignClient {


    @GetMapping(value = "/ping")
    public String ping();
}
