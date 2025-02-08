package com.example.TeamManagementService.Repos;

import com.example.TeamManagementService.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring Data repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Inherits CRUD operations from JpaRepository
}