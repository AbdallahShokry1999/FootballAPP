package com.example.PayementService.feign;


import com.example.PayementService.DTOs.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service", url = "http://localhost:8085")
public interface ItemFeignClient {

    @GetMapping("/items/{id}")
    ItemDTO getItemById(@PathVariable Long id);
}
