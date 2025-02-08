package com.example.TeamManagementService.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TeamDTO {

    @NotBlank(message = "Name is required") // Ensures the name is not blank
    private String name;

    @NotBlank(message = "Country is required") // Ensures the country is not blank
    private String country;

    @NotNull(message = "Founded year is required") // Ensures the founded year is not null
    private Integer foundedYear;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }
}