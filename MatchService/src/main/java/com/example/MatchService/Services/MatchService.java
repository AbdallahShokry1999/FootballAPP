package com.example.MatchService.Services;




import com.example.MatchService.DTOs.MatchResponseDTO;
import com.example.MatchService.Feign.TeamFeignClient;
import com.example.MatchService.Models.Match;
import com.example.MatchService.Repos.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamFeignClient teamFeignClient;

    public List<MatchResponseDTO> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public MatchResponseDTO getMatchById(Long matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        return mapToDTO(match);
    }

    public MatchResponseDTO createMatch(MatchResponseDTO matchDTO) {
        Match match = new Match();
        match.setHomeTeamId(matchDTO.getHomeTeam().getId());
        match.setAwayTeamId(matchDTO.getAwayTeam().getId());
        match.setMatchDate(matchDTO.getMatchDate());
        match.setResult(matchDTO.getResult());

        Match savedMatch = matchRepository.save(match);
        return mapToDTO(savedMatch);
    }

    public MatchResponseDTO updateMatchResult(Long matchId, String result) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        match.setResult(result);
        Match updatedMatch = matchRepository.save(match);
        return mapToDTO(updatedMatch);
    }

    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    private MatchResponseDTO mapToDTO(Match match) {
        MatchResponseDTO dto = new MatchResponseDTO();
        dto.setId(match.getId());
        dto.setHomeTeam(teamFeignClient.getTeamById(match.getHomeTeamId()));
        dto.setAwayTeam(teamFeignClient.getTeamById(match.getAwayTeamId()));
        dto.setMatchDate(match.getMatchDate());
        dto.setResult(match.getResult());
        return dto;
    }
}
