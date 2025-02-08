package com.example.TeamManagementService.Repos;

import com.example.TeamManagementService.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByTeamId(Long teamId); // Finds all staff members in a specific team
}