package com.example.TeamManagementService.Controllers;

import com.example.TeamManagementService.DTOs.PlayerDTO;
import com.example.TeamManagementService.Models.Player;
import com.example.TeamManagementService.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/players") // Base URL for all endpoints in this controller
public class PlayerController {

    @Autowired // Injects the PlayerService dependency
    private PlayerService playerService;

    // Creates a new player
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO playerDTO) {
        Player player = playerService.createPlayer(playerDTO);
        return ResponseEntity.ok(player); // Returns the created player with HTTP 200
    }

    // Retrieves all players
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players); // Returns all players with HTTP 200
    }

    // Retrieves a player by ID
    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        Optional<Player> player = playerService.getPlayerById(playerId);
        return player.map(ResponseEntity::ok) // Returns the player if found
                .orElse(ResponseEntity.notFound().build()); // Returns HTTP 404 if not found
    }

    // Deletes a player by ID
    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build(); // Returns HTTP 204 (No Content)
    }

    // Transfers a player to a new team
    @PutMapping("/{playerId}/transfer/{newTeamId}")
    public ResponseEntity<Player> transferPlayer(
            @PathVariable Long playerId,
            @PathVariable Long newTeamId) {
        Optional<Player> player = playerService.transferPlayer(playerId, newTeamId);
        return player.map(ResponseEntity::ok) // Returns the updated player if successful
                .orElse(ResponseEntity.badRequest().build()); // Returns HTTP 400 if failed
    }

    // Retires a player
    @PutMapping("/{playerId}/retire")
    public ResponseEntity<Player> retirePlayer(@PathVariable Long playerId) {
        Optional<Player> player = playerService.retirePlayer(playerId);
        return player.map(ResponseEntity::ok) // Returns the retired player if successful
                .orElse(ResponseEntity.notFound().build()); // Returns HTTP 404 if player not found
    }
}