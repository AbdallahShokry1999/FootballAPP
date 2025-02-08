package com.example.TeamManagementService.Repos;

import com.example.TeamManagementService.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Inherits CRUD operations from JpaRepository
    List<Player> findByTeamId(Long teamId); // Finds all players in a specific team
}