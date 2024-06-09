package com.example.demo.controller.project.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequest {

    @NotBlank
    private String projectName;

    @NotBlank
    private String status;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

}
