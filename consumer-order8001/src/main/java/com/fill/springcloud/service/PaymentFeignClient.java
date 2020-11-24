package com.fill.springcloud.service;

import com.fill.springcloud.fallback.PaymentFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "payment", fallbackFactory = PaymentFeignClientFallbackFactory.class)
public interface PaymentFeignClient {

    @GetMapping(value = "/payment/{id}")
    public String getPaymentById(@PathVariable(value = "id") long id);

    @GetMapping(value = "/payment/hystrix/{id}")
    public String hystrix(@PathVariable(value = "id") long id);
}
