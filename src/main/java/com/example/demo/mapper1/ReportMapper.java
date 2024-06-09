package com.example.demo.mapper1;

import com.example.demo.controller.report.request.CreateReportRequest;
import com.example.demo.controller.report.response.ReportResponse;
import com.example.demo.repository.project.Project;
import com.example.demo.repository.report.Report;
import com.example.demo.repository.task.Task;

public class ReportMapper {

   public static Report toEntity(CreateReportRequest request, Task task, Project project){
       if (request == null || task == null || project == null){
           return null;
       }

       return Report.builder()
               .reportTitle(request.getReportTitle())
               .content(request.getContent())
               .createdDate(request.getCreatedDate())
               .task(task)
               .project(project)
               .build();
   }

   public static ReportResponse toResponse (Report report){

       if (report == null){
           return null;
       }

       return ReportResponse.builder()
               .reportTitle(report.getReportTitle())
               .content(report.getContent())
               .createdDate(report.getCreatedDate())
               .taskId(report.getTask().getId())
               .projectId(report.getProject().getId())
               .build();
   }
}
