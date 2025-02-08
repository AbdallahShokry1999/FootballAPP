package com.example.TeamManagementService.Services;

import com.example.TeamManagementService.DTOs.TeamDTO;
import com.example.TeamManagementService.Models.Team;
import com.example.TeamManagementService.Repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class TeamService {

    @Autowired // Injects the TeamRepository dependency
    private TeamRepository teamRepository;

    // Creates a new team
    public Team createTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setCountry(teamDTO.getCountry());
        team.setFoundedYear(teamDTO.getFoundedYear());
        return teamRepository.save(team); // Saves the team to the database
    }

    // Retrieves all teams
    public List<Team> getAllTeams() {
        return teamRepository.findAll(); // Returns all teams from the database
    }

    // Retrieves a team by ID
    public Optional<Team> getTeamById(Long teamId) {
        return teamRepository.findById(teamId); // Finds a team by ID
    }

    // Updates a team
    public Team updateTeam(Long id, TeamDTO updatedTeamDTO) {
        return teamRepository.findById(id).map(existingTeam -> {
            existingTeam.setName(updatedTeamDTO.getName());
            existingTeam.setCountry(updatedTeamDTO.getCountry());
            existingTeam.setFoundedYear(updatedTeamDTO.getFoundedYear());
            return teamRepository.save(existingTeam); // Saves the updated team
        }).orElseThrow(() -> new RuntimeException("Team not found with ID: " + id));
    }

    // Deletes a team by ID
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId); // Deletes a team from the database
    }
}