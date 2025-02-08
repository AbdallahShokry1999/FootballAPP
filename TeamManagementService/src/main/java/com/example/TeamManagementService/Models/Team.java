package com.example.TeamManagementService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity // Marks this class as a JPA entity (maps to a database table)
@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@ToString
public class Team {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID
    private Long id; // Unique identifier for the team

    private String name; // Name of the team
    private String country; // Country where the team is based
    private Integer foundedYear; // Year the team was founded

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // This prevents infinite recursion when serializing JSON

    private List<Player> players = new ArrayList<>(); // List of players in the team

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // This prevents infinite recursion when serializing JSON
    //for prevent loops inside loops etc...
    private List<Staff> staffMembers = new ArrayList<>(); // List of staff members in the team
}