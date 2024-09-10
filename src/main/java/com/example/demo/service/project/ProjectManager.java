package com.example.demo.service.project;


import com.example.demo.controller.project.request.CreateProjectRequest;
import com.example.demo.controller.project.request.UpdateProjectRequest;
import com.example.demo.controller.project.response.ProjectResponse;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.exception.type.NotFoundExceptionType;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.project.Project;
import com.example.demo.repository.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectManager implements ProjectService{

    private final ProjectRepository projectRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateProjectRequest createProjectRequest) {
        Project project = mapperService.forRequest().map(createProjectRequest, Project.class);
        projectRepository.save(project);
    }

    @Override
    public void update(UpdateProjectRequest updateProjectRequest) {
        projectRepository.findById(updateProjectRequest.getId())
                .orElseThrow(()-> new NotFoundException(NotFoundExceptionType.PROJECT_DATA_NOT_FOUND ));
        Project project =mapperService.forRequest().map(updateProjectRequest, Project.class);
        projectRepository.save(project);

    }

    @Override
    public ProjectResponse getById(int id) {
       Project project = projectRepository.findById(id).orElseThrow(() -> new NotFoundException(NotFoundExceptionType.PROJECT_DATA_NOT_FOUND ));
       return  mapperService.forResponse().map(project, ProjectResponse.class);
    }

    @Override
    public List<ProjectResponse> getAll() {
        List<Project> projects = projectRepository.findAll();
        if (projects.isEmpty()){
            throw new NotFoundException(NotFoundExceptionType.PROJECT_LIST_NOT_FOUND);
        }
        return projects.stream().map(project -> mapperService.forResponse().map(project, ProjectResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
      projectRepository.findById(id).orElseThrow(() -> new NotFoundException(NotFoundExceptionType.PROJECT_DATA_NOT_FOUND ));
      projectRepository. deleteById(id);
    }
}
