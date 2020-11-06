package com.fill.springcloud.mvc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentRestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/{id}")
    public String getPaymentInfoById(
            @PathVariable(value = "id") long id) {
        logger.debug("get payment, id:{}", id);
        return UUID.randomUUID().toString();
    }
}