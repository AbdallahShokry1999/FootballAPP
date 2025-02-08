package com.example.MatchService.Controllers;


import com.example.MatchService.DTOs.MatchResponseDTO;
import com.example.MatchService.Services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // Get all matches with team names instead of just IDs
    @GetMapping
    public List<MatchResponseDTO> getAllMatches() {
        return matchService.getAllMatches();
    }

    // Get a match by ID
    @GetMapping("/{matchId}")
    public MatchResponseDTO getMatchById(@PathVariable Long matchId) {
        return matchService.getMatchById(matchId);
    }

    // Create a new match
    @PostMapping
    public MatchResponseDTO createMatch(@RequestBody MatchResponseDTO matchDTO) {
        return matchService.createMatch(matchDTO);
    }

    // Update a match result
    @PutMapping("/{matchId}")
    public MatchResponseDTO updateMatchResult(@PathVariable Long matchId, @RequestParam String result) {
        return matchService.updateMatchResult(matchId, result);
    }

    // Delete a match
    @DeleteMapping("/{matchId}")
    public void deleteMatch(@PathVariable Long matchId) {
        matchService.deleteMatch(matchId);
    }
}
