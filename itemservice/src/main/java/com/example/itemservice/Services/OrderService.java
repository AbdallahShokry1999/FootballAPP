package com.example.itemservice.Services;






import com.example.itemservice.Models.Item;
import com.example.itemservice.Models.Order;
import com.example.itemservice.Repository.ItemRepository;
import com.example.itemservice.Repository.OrderRepository;
import com.example.itemservice.feign.PaymentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {



    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Order createOrder(List<Long> itemIds, String customerEmail) {
        List<Item> items = itemRepository.findAllById(itemIds);
        double totalAmount = items.stream().mapToDouble(Item::getPrice).sum();

        Order order = new Order();
        order = orderRepository.save(order);

        sendOrderConfirmationEmail(customerEmail, order.getId(), totalAmount);

        return order;
    }

    private void sendOrderConfirmationEmail(String email, Long orderId, Double amount) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Order Confirmation - #" + orderId);
        message.setText("Your order #" + orderId + " has been placed successfully! Total: $" + amount);
        mailSender.send(message);
    }
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);  // Returns order if found, otherwise null
    }
    private final PaymentFeignClient paymentFeignClient;

    @Autowired
    public OrderService(PaymentFeignClient paymentFeignClient) {
        this.paymentFeignClient = paymentFeignClient;
    }

    public String placeOrder(Long orderId, Double amount) {
        // Call PaymentService using Feign Client
        String paymentResponse = PaymentFeignClient.processPayment(orderId, amount);
        return "Order placed successfully! Payment response: " + paymentResponse;
    }
}

