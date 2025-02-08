package com.example.TeamManagementService.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // Marks this class as a JPA entity (maps to a database table)
@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
public class Staff {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id; // Unique identifier for the staff member

    private String name; // Name of the staff member
    private String role; // Role of the staff member (e.g., Coach, Manager)

    @ManyToOne // Many staff members can belong to one team
    @JoinColumn(name = "team_id") // Foreign key to the Team table


    private Team team; // The team the staff member belongs to
}