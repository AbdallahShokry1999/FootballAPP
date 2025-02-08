package com.example.TeamManagementService.Controllers;

import com.example.TeamManagementService.DTOs.TeamDTO;
import com.example.TeamManagementService.Models.Team;
import com.example.TeamManagementService.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/teams") // Base URL for all endpoints in this controller
public class TeamController {

    @Autowired // Injects the TeamService dependency
    private TeamService teamService;

    // Creates a new team
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        Team team = teamService.createTeam(teamDTO);
        return ResponseEntity.ok(team); // Returns the created team with HTTP 200
    }

    // Retrieves all teams
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams); // Returns all teams with HTTP 200
    }

    // Retrieves a team by ID
    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long teamId) {
        Optional<Team> team = teamService.getTeamById(teamId);
        return team.map(ResponseEntity::ok) // Returns the team if found
                .orElse(ResponseEntity.notFound().build()); // Returns HTTP 404 if not found
    }

    // Updates a team
    @PutMapping("/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamId, @RequestBody TeamDTO teamDTO) {
        Team updatedTeam = teamService.updateTeam(teamId, teamDTO);
        return ResponseEntity.ok(updatedTeam); // Returns the updated team with HTTP 200
    }

    // Deletes a team by ID
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.noContent().build(); // Returns HTTP 204 (No Content)
    }
}