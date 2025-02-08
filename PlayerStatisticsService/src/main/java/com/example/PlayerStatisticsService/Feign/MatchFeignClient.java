package com.example.PlayerStatisticsService.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MatchService", url = "http://localhost:8082")
public interface MatchFeignClient {
    @GetMapping("/matches/{matchId}")
    Object getMatchById(@PathVariable Long matchId);
}
