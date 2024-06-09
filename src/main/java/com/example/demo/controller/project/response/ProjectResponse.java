package com.example.demo.controller.project.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {

    private String projectName;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;
}
