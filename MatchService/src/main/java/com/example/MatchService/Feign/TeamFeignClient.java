package com.example.MatchService.Feign;


import com.example.MatchService.DTOs.PlayerDTO;
import com.example.MatchService.DTOs.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "team-service", url = "http://localhost:8080")
public interface TeamFeignClient {

    @GetMapping("/api/teams/{teamId}")
    TeamDTO getTeamById(@PathVariable Long teamId);
    @GetMapping("/players/{id}")
    PlayerDTO getPlayerById(@PathVariable("id") Long id);
}