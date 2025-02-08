package com.example.MatchService.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchResponseDTO {
    private Long id;
    private TeamDTO homeTeam;  // Instead of just homeTeamId
    private TeamDTO awayTeam;
    private LocalDateTime matchDate;
    private String result;
}