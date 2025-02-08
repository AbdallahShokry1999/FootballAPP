package com.example.TeamManagementService.Services;

import com.example.TeamManagementService.DTOs.PlayerDTO;
import com.example.TeamManagementService.Models.Player;
import com.example.TeamManagementService.Models.Team;
import com.example.TeamManagementService.Repos.PlayerRepository;
import com.example.TeamManagementService.Repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class PlayerService {

    @Autowired // Injects the PlayerRepository dependency
    private PlayerRepository playerRepository;

    @Autowired // Injects the TeamRepository dependency
    private TeamRepository teamRepository;

    // Creates a new player
    public Player createPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setPosition(playerDTO.getPosition());

        // Finds the team by ID and assigns it to the player
        Optional<Team> team = teamRepository.findById(playerDTO.getTeamId());
        team.ifPresent(player::setTeam);

        return playerRepository.save(player); // Saves the player to the database
    }

    // Retrieves all players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll(); // Returns all players from the database
    }

    // Retrieves a player by ID
    public Optional<Player> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId); // Finds a player by ID
    }

    // Deletes a player by ID
    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId); // Deletes a player from the database
    }

    // Transfers a player to a new team
    public Optional<Player> transferPlayer(Long playerId, Long newTeamId) {
        Optional<Player> playerOpt = playerRepository.findById(playerId);
        Optional<Team> newTeamOpt = teamRepository.findById(newTeamId);

        if (playerOpt.isPresent() && newTeamOpt.isPresent()) {
            Player player = playerOpt.get();
            Team newTeam = newTeamOpt.get();
            player.setTeam(newTeam); // Assigns the player to the new team
            return Optional.of(playerRepository.save(player)); // Saves the updated player
        }
        return Optional.empty(); // Returns empty if the player or team is not found
    }

    // Retires a player (marks them as retired and removes them from their team)
    public Optional<Player> retirePlayer(Long playerId) {
        Optional<Player> playerOpt = playerRepository.findById(playerId);
        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            player.setRetired(true); // Marks the player as retired
            player.setTeam(null); // Removes the player from their team
            return Optional.of(playerRepository.save(player)); // Saves the updated player
        }
        return Optional.empty(); // Returns empty if the player is not found
    }
}