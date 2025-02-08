package com.example.PlayerStatisticsService.Controllers;


import com.example.PlayerStatisticsService.DTOs.PlayerStatisticsDTO;
import com.example.PlayerStatisticsService.Models.PlayerStatistics;
import com.example.PlayerStatisticsService.Services.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player-stats")
public class PlayerStatisticsController {
    @Autowired
    private PlayerStatisticsService service;

    @PostMapping
    public ResponseEntity<PlayerStatistics> addPlayerStatistics(@RequestBody PlayerStatisticsDTO dto) {
        return ResponseEntity.ok(service.addPlayerStatistics(dto));
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<PlayerStatistics>> getPlayerStatistics(@PathVariable Long playerId) {
        return ResponseEntity.ok(service.getPlayerStatisticsByPlayerId(playerId));
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity<List<PlayerStatistics>> getMatchStatistics(@PathVariable Long matchId) {
        return ResponseEntity.ok(service.getPlayerStatisticsByMatchId(matchId));
    }
}
