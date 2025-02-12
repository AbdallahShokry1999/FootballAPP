package com.example.PayementService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequest {
    private Double total;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private String cancelUrl;
    private String successUrl;


}
