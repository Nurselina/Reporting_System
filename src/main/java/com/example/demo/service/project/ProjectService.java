package com.example.demo.service.project;

import com.example.demo.controller.project.request.CreateProjectRequest;
import com.example.demo.controller.project.request.UpdateProjectRequest;
import com.example.demo.controller.project.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    void create(CreateProjectRequest createProjectRequest);

    void update(UpdateProjectRequest updateProjectRequest);

    ProjectResponse getById(int id);

    List<ProjectResponse> getAll();

    void delete(int id);
}
