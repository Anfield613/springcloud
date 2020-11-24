package com.fill.springcloud.fallback;

import com.fill.springcloud.service.PaymentFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignClientFallbackFactory implements FallbackFactory<PaymentFeignClient> {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public PaymentFeignClient create(final Throwable throwable) {
        return new PaymentFeignClient() {
            public String getPaymentById(long id) {
                return throwable.getLocalizedMessage();
            }

            public String hystrix(long id) {
                logger.error(this.getClass() + ": hystrix");
                return "hystrix: " + throwable.getMessage();
            }
        };
    }
}
