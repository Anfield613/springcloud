package com.fill.filestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * <p>
 *
 * @author <a href="mailto:coderFill@hotmail.com">fangzizhong</a>
 * @version 1.0, 2020-12-04
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableOpenApi
public class FileStorageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileStorageServerApplication.class, args);
    }
}
