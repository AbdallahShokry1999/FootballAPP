package com.example.itemservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-service", url = "http://localhost:8081/payments") // Change URL if needed
public interface PaymentFeignClient {

    @PostMapping("/process")
    static String processPayment(@RequestParam("orderId") Long orderId, @RequestParam("amount") Double amount) {
        return null;
    }
}
