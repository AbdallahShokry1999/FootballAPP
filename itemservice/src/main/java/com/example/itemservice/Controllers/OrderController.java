package com.example.itemservice.Controllers;

import com.example.itemservice.Models.Order;
import com.example.itemservice.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestParam List<Long> itemIds, @RequestParam String email) {
        return orderService.createOrder(itemIds, email);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/pay/{orderId}")
    public String processPayment(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return paymentService.createPayment(order.getTotalAmount());
    }

}
