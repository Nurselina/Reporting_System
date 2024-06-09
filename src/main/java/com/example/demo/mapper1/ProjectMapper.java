package com.example.demo.mapper1;

import com.example.demo.controller.project.request.CreateProjectRequest;
import com.example.demo.controller.project.response.ProjectResponse;
import com.example.demo.repository.project.Project;

public class ProjectMapper {

    public static Project toEntity (CreateProjectRequest request){
        if(request == null){
            return null;
        }
        return Project.builder()
                .projectName(request.getProjectName())
                .status(request.getStatus())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();
    }

    public static ProjectResponse toResponse (Project project){
        if(project == null){
            return null;
        }

        return ProjectResponse.builder()
                .projectName(project.getProjectName())
                .status(project.getStatus())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .build();
    }
}
