package com.fill.springcloud.mvc;


import com.fill.springcloud.service.PaymentFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaymentFeignClient paymentFeignClient;


    @GetMapping(value = "/payment/{id}")
    public String getPaymentInfoById(@PathVariable(name = "id") long id) {
        return paymentFeignClient.getPaymentById(id);
    }
}
