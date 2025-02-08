package com.example.MatchService.Services;



import com.example.MatchService.DTOs.TournamentDTO;
import com.example.MatchService.Feign.TeamFeignClient;
import com.example.MatchService.Models.Tournament;
import com.example.MatchService.Repos.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamFeignClient playerFeignClient;

    // Fetch player name from Player Service
    private String getPlayerName(Long playerId) {
        if (playerId == null) return null;
        try {
            return playerFeignClient.getPlayerById(playerId).getName();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    // Convert Tournament to TournamentDTO
    private TournamentDTO convertToDTO(Tournament tournament) {
        TournamentDTO dto = new TournamentDTO();
        dto.setId(tournament.getId());
        dto.setName(tournament.getName());
        dto.setLocation(tournament.getLocation());
        dto.setYear(tournament.getYear());

        dto.setTopScorerId(tournament.getTopScorerId());
        dto.setTopScorerName(getPlayerName(tournament.getTopScorerId()));

        dto.setTopAssisterId(tournament.getTopAssisterId());
        dto.setTopAssisterName(getPlayerName(tournament.getTopAssisterId()));

        dto.setBestGoalkeeperId(tournament.getBestGoalkeeperId());
        dto.setBestGoalkeeperName(getPlayerName(tournament.getBestGoalkeeperId()));

        return dto;
    }

    // Get all tournaments with player names
    public List<TournamentDTO> getAllTournaments() {
        return tournamentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get a tournament by ID with player names
    public Optional<TournamentDTO> getTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Create a new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Update an existing tournament
    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        return tournamentRepository.findById(id)
                .map(tournament -> {
                    tournament.setName(updatedTournament.getName());
                    tournament.setLocation(updatedTournament.getLocation());
                    tournament.setYear(updatedTournament.getYear());
                    tournament.setTopScorerId(updatedTournament.getTopScorerId());
                    tournament.setTopAssisterId(updatedTournament.getTopAssisterId());
                    tournament.setBestGoalkeeperId(updatedTournament.getBestGoalkeeperId());
                    return tournamentRepository.save(tournament);
                })
                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + id));
    }

    // Delete a tournament
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
