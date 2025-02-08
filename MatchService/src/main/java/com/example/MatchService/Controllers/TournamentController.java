package com.example.MatchService.Controllers;

import com.example.MatchService.DTOs.TournamentDTO;
import com.example.MatchService.Models.Tournament;
import com.example.MatchService.Services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // Get all tournaments
    @GetMapping
    public ResponseEntity<List<TournamentDTO>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    // Get tournament by ID
    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> getTournamentById(@PathVariable Long id) {
        Optional<TournamentDTO> tournament = tournamentService.getTournamentById(id);
        return tournament.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a tournament
    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.createTournament(tournament));
    }

    // Update a tournament
    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.updateTournament(id, tournament));
    }

    // Delete a tournament
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
