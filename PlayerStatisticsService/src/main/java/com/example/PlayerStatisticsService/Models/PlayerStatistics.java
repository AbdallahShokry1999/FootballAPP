package com.example.PlayerStatisticsService.Models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String playerName;  // Now we return the player's name
    private Long playerId; // References Player from Team Management Service
    private Long matchId;  // References Match from Match Service
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int minutesPlayed;
}
