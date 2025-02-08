package com.example.PlayerStatisticsService.Repos;


import com.example.PlayerStatisticsService.Models.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {
    List<PlayerStatistics> findByPlayerId(Long playerId);
    List<PlayerStatistics> findByMatchId(Long matchId);
}
