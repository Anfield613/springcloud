package com.fill.filestorage.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>
 *
 * @author <a href="mailto:coderFill@hotmail.com">fangzizhong</a>
 * @version 1.0, 2020-12-04
 */
@Configuration
public class FileStorageSwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any())
            .build();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RestAPI接口文档")
            .description("文件存储微服务RestAPI接口文档")
            .version("1.0")
            .build();
    }
}
