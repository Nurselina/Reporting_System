package com.example.demo.controller.report.request;

import com.example.demo.repository.project.Project;
import com.example.demo.repository.task.Task;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class CreateReportRequest {

    @NotBlank
    private String reportTitle;

    @NotBlank
    private String content;

    @NotNull
    private LocalDate createdDate;

    @NotNull
    private int taskId;

    @NotNull
    private int projectId;
}
