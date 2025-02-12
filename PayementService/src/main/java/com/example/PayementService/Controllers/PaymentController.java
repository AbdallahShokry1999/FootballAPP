package com.example.PayementService.Controllers;

import com.example.PayementService.Models.PaymentRequest;
import com.example.PayementService.Models.User;
import com.example.PayementService.Services.PaymentService;
import com.example.PayementService.Services.UserService;
import com.example.PayementService.security.JwtUtil;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create a payment (POST endpoint)
    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Call the payment service to create a PayPal payment
            Payment payment = paymentService.createPayment(
                    paymentRequest.getTotal(),
                    paymentRequest.getCurrency(),
                    paymentRequest.getMethod(),
                    paymentRequest.getIntent(),
                    paymentRequest.getDescription(),
                    paymentRequest.getCancelUrl(),
                    paymentRequest.getSuccessUrl()
            );
            // Return the created payment response
            return ResponseEntity.ok(payment);
        } catch (PayPalRESTException e) {
            // Handle PayPal error and return a response with a failure status
            return ResponseEntity.status(500).body(null);
        }
    }

    // Cancel the payment (GET endpoint)
    @GetMapping("/cancel")
    public ResponseEntity<String> cancelPayment() {
        // Handle cancelation logic here (if any)
        return ResponseEntity.ok("Payment was canceled.");
    }

    // Success payment response (GET endpoint)
    @GetMapping("/success")
    public ResponseEntity<String> successPayment() {
        // Handle success logic here, e.g., save transaction to database
        return ResponseEntity.ok("Payment was successful.");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            return jwtUtil.generateToken(user.getUsername());
        } catch (Exception e) {
            try {
                throw new UnauthorizedException("Invalid credentials");
            } catch (UnauthorizedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
}

class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}
