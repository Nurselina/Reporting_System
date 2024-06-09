package com.example.demo.repository.report;

import com.example.demo.core.Base;
import com.example.demo.repository.project.Project;
import com.example.demo.repository.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "reports")
public class Report extends Base {

    @Column(name = "report_title")
    private String reportTitle;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
