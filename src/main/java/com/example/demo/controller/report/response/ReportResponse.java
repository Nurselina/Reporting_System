package com.example.demo.controller.report.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportResponse {

    private String reportTitle;

    private String content;

    private LocalDate createdDate;

    private int taskId;

    private int projectId;
}
