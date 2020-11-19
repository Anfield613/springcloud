package com.fill.springcloud.mvc;

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
    public String getPaymentById(@PathVariable(value = "id") long id) {

        logger.debug("get payment info , id:{}", id);

        return UUID.randomUUID().toString() + ", port:" + port;

    }

}
