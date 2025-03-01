package com.eugen.obiedkov.OrderService.external.client;

import com.eugen.obiedkov.OrderService.exception.CustomException;
import com.eugen.obiedkov.OrderService.external.request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CircuitBreaker(name="external", fallbackMethod = "fallback")
@FeignClient(name = "PAYMENT-SERVICE", path = "/payment")
public interface PaymentService {

    @PostMapping
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    default void fallback(Exception e) {
        throw new CustomException("Payment Service is not available",
                HttpStatus.SERVICE_UNAVAILABLE, 500);
    }
}
