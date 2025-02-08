package com.example.MatchService.Models;




import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    @Column(name = "year")
    private Integer year; // ✅ Change from 'int' to 'Integer'
    private Long topScorerId;   // Player with the most goals
    private Long topAssisterId; // Player with the most assists
    private Long bestGoalkeeperId; // Goalkeeper with the most clean sheets
}
