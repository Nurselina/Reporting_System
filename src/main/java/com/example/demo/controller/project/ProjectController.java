package com.example.demo.controller.project;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.project.request.CreateProjectRequest;
import com.example.demo.controller.project.request.UpdateProjectRequest;
import com.example.demo.controller.project.response.ProjectResponse;
import com.example.demo.service.project.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/projects")
public class ProjectController extends BaseController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody @Valid CreateProjectRequest createProjectRequest){
        projectService.create(createProjectRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updateProject(@RequestBody @Valid UpdateProjectRequest updateProjectRequest){
        projectService.update(updateProjectRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getByIdProject(@PathVariable int id){
        return answer(projectService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects(){
        return answer(projectService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id){
        projectService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }






}
