package com.example.PayementService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // Buyer ID
    private Long teamId;  // Team ID for which the item was bought
    private Long itemId;  // Purchased Item ID
    private double amount;
    private String status;  // PENDING, COMPLETED, FAILED
    private LocalDateTime paymentDate;
}