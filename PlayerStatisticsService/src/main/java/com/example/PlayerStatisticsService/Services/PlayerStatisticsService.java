package com.example.PlayerStatisticsService.Services;



import com.example.PlayerStatisticsService.DTOs.PlayerStatisticsDTO;
import com.example.PlayerStatisticsService.Feign.MatchFeignClient;
import com.example.PlayerStatisticsService.Models.PlayerStatistics;
import com.example.PlayerStatisticsService.Repos.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatisticsService {
    @Autowired
    private PlayerStatisticsRepository repository;

    @Autowired
    private MatchFeignClient matchFeignClient; // Inject Match Service Client

    public PlayerStatistics addPlayerStatistics(PlayerStatisticsDTO dto) {
        // Check if match exists before adding stats
        Object match = matchFeignClient.getMatchById(dto.getMatchId());
        if (match == null) {
            throw new RuntimeException("Match not found!");
        }

        PlayerStatistics stats = new PlayerStatistics();
        stats.setPlayerId(dto.getPlayerId());
        stats.setMatchId(dto.getMatchId());
        stats.setGoals(dto.getGoals());
        stats.setAssists(dto.getAssists());
        stats.setYellowCards(dto.getYellowCards());
        stats.setRedCards(dto.getRedCards());
        stats.setMinutesPlayed(dto.getMinutesPlayed());

        return repository.save(stats);
    }
    public List<PlayerStatistics> getPlayerStatisticsByPlayerId(Long playerId) {
        return repository.findByPlayerId(playerId);
    }

    public List<PlayerStatistics> getPlayerStatisticsByMatchId(Long matchId) {
        return repository.findByMatchId(matchId);
    }
}

