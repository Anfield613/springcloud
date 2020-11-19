package com.fill.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("payment")
public interface PaymentFeignClient {

    @GetMapping(value = "/payment/{id}")
    public String getPaymentById(@PathVariable(value = "id") long id);
}
