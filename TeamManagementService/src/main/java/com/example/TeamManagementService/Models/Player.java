package com.example.TeamManagementService.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // Marks this class as a JPA entity (maps to a database table)
@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
public class Player {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID

    private Long id; // Unique identifier for the player

    private String name; // Name of the player
    private String position; // Position of the player (e.g., Forward, Midfielder)
    private boolean retired = false; // Indicates if the player is retired

    @ManyToOne // Many players can belong to one team
    @JoinColumn(name = "team_id") // Foreign key to the Team table
    //@JsonIgnore // This prevents infinite recursion when serializing JSON

    private Team team; // The team the player belongs to
}