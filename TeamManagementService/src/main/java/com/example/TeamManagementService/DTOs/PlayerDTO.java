package com.example.TeamManagementService.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PlayerDTO {

    @NotBlank(message = "Name is required") // Ensures the name is not blank
    private String name;

    @NotBlank(message = "Position is required") // Ensures the position is not blank
    private String position;

    @NotNull(message = "Team ID is required") // Ensures the team ID is not null
    private Long teamId;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}