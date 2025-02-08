package com.example.PlayerStatisticsService.DTOs;


import lombok.Data;

@Data
public class PlayerStatisticsDTO {
    private Long playerId;
    private Long matchId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int minutesPlayed;
}

