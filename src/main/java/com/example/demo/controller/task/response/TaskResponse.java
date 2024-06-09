package com.example.demo.controller.task.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {

    private String title;

    private String description;

    private String status;

    private LocalDate createdDate;
}
