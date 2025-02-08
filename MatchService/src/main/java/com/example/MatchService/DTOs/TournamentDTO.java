package com.example.MatchService.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDTO {
    private Long id;
    private String name;
    private String location;
    private int year;

    private Long topScorerId;
    private String topScorerName;

    private Long topAssisterId;
    private String topAssisterName;

    private Long bestGoalkeeperId;
    private String bestGoalkeeperName;
}
