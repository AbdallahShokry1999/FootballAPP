package com.example.PayementService.DTOs;


import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
}
