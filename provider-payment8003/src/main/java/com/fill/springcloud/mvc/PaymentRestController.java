package com.fill.springcloud.mvc;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentRestController {


    private Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${server.port}")
    private int port;


    @GetMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "fallback")
    public String getPaymentById(@PathVariable(value = "id") long id) {
        logger.debug("get payment info , id:{}", id);
        return UUID.randomUUID().toString() + ", port:" + port;
    }


    @GetMapping(value = "/hystrix/{id}")
    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            }
    )
    public String hystrix(@PathVariable(value = "id") long id) throws InterruptedException {
        logger.debug("hystrix , id:{}", id);
        Thread.sleep(2000);
        return UUID.randomUUID().toString() + ", port:" + port;
    }


    public String fallback(long id) {
        return "hystrix";
    }

}
