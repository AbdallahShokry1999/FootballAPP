package com.example.TeamManagementService.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StaffDTO {

    @NotBlank(message = "Name is required") // Ensures the name is not blank
    private String name;

    @NotBlank(message = "Role is required") // Ensures the role is not blank
    private String role;

    @NotNull(message = "Team ID is required") // Ensures the team ID is not null
    private Long teamId;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}