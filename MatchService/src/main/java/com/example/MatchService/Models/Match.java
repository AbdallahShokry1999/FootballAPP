package com.example.MatchService.Models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long homeTeamId;
    private Long awayTeamId;
    private LocalDateTime matchDate;
    private String result;
}
