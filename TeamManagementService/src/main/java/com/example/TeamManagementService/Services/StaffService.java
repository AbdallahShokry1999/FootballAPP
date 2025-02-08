package com.example.TeamManagementService.Services;

import com.example.TeamManagementService.DTOs.StaffDTO;
import com.example.TeamManagementService.Models.Staff;
import com.example.TeamManagementService.Models.Team;
import com.example.TeamManagementService.Repos.StaffRepository;
import com.example.TeamManagementService.Repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class StaffService {

    @Autowired // Injects the StaffRepository dependency
    private StaffRepository staffRepository;

    @Autowired // Injects the TeamRepository dependency
    private TeamRepository teamRepository;

    // Adds a new staff member
    public Staff addStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setName(staffDTO.getName());
        staff.setRole(staffDTO.getRole());

        // Finds the team by ID and assigns it to the staff member
        Optional<Team> team = teamRepository.findById(staffDTO.getTeamId());
        team.ifPresent(staff::setTeam);

        return staffRepository.save(staff); // Saves the staff member to the database
    }

    // Retrieves all staff members
    public List<Staff> getAllStaff() {
        return staffRepository.findAll(); // Returns all staff members from the database
    }

    // Retrieves a staff member by ID
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id); // Finds a staff member by ID
    }

    // Retrieves all staff members in a specific team
    public List<Staff> getStaffByTeamId(Long teamId) {
        return staffRepository.findByTeamId(teamId); // Returns all staff members in the team
    }

    // Updates a staff member
    public Staff updateStaff(Long id, StaffDTO updatedStaffDTO) {
        return staffRepository.findById(id).map(existingStaff -> {
            existingStaff.setName(updatedStaffDTO.getName());
            existingStaff.setRole(updatedStaffDTO.getRole());

            // Finds the team by ID and assigns it to the staff member
            Optional<Team> team = teamRepository.findById(updatedStaffDTO.getTeamId());
            team.ifPresent(existingStaff::setTeam);

            return staffRepository.save(existingStaff); // Saves the updated staff member
        }).orElseThrow(() -> new RuntimeException("Staff not found with ID: " + id));
    }

    // Deletes a staff member by ID
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id); // Deletes a staff member from the database
    }
}