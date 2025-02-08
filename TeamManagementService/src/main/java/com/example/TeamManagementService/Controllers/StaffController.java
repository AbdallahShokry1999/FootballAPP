package com.example.TeamManagementService.Controllers;

import com.example.TeamManagementService.DTOs.StaffDTO;
import com.example.TeamManagementService.Models.Staff;
import com.example.TeamManagementService.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/staff") // Base URL for all endpoints in this controller
public class StaffController {

    @Autowired // Injects the StaffService dependency
    private StaffService staffService;

    // Adds a new staff member
    @PostMapping
    public ResponseEntity<Staff> addStaff(@RequestBody StaffDTO staffDTO) {
        Staff staff = staffService.addStaff(staffDTO);
        return ResponseEntity.ok(staff); // Returns the created staff member with HTTP 200
    }

    // Retrieves all staff members
    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staff = staffService.getAllStaff();
        return ResponseEntity.ok(staff); // Returns all staff members with HTTP 200
    }

    // Retrieves a staff member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.getStaffById(id);
        return staff.map(ResponseEntity::ok) // Returns the staff member if found
                .orElse(ResponseEntity.notFound().build()); // Returns HTTP 404 if not found
    }

    // Retrieves all staff members in a specific team
    @GetMapping("/team/{teamId}")
    public ResponseEntity<List<Staff>> getStaffByTeamId(@PathVariable Long teamId) {
        List<Staff> staff = staffService.getStaffByTeamId(teamId);
        return ResponseEntity.ok(staff); // Returns all staff members in the team with HTTP 200
    }

    // Updates a staff member
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody StaffDTO staffDTO) {
        Staff updatedStaff = staffService.updateStaff(id, staffDTO);
        return ResponseEntity.ok(updatedStaff); // Returns the updated staff member with HTTP 200
    }

    // Deletes a staff member by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build(); // Returns HTTP 204 (No Content)
    }
}