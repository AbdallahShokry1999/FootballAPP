package com.example.PayementService.feign;


import com.example.PayementService.DTOs.TeamDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "team-service", url = "http://localhost:8080")
public interface TeamFeignClient {

    @GetMapping("/teams/{teamId}")
    TeamDTO getTeamById(@PathVariable Long teamId);
}
