package com.example.demo.controller.project;

import com.example.demo.controller.project.request.CreateProjectRequest;
import com.example.demo.controller.project.request.UpdateProjectRequest;
import com.example.demo.controller.project.response.ProjectResponse;
import com.example.demo.service.project.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public void createProject(@RequestBody @Valid CreateProjectRequest createProjectRequest){
        projectService.create(createProjectRequest);
    }

    @PutMapping
    public void updateProject(@RequestBody @Valid UpdateProjectRequest updateProjectRequest){
        projectService.update(updateProjectRequest);
    }

    @GetMapping("/{id}")
    public ProjectResponse getByIdProject(@PathVariable int id){
        return projectService.getById(id);
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects(){
        return projectService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id){
        projectService.delete(id);
    }






}
