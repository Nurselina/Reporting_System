package com.example.demo.service.task;


import com.example.demo.controller.task.request.CreateTaskRequest;
import com.example.demo.controller.task.request.UpdateTaskRequest;
import com.example.demo.controller.task.response.TaskResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.task.Task;
import com.example.demo.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskManager implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateTaskRequest createTaskRequest) {
        Task task = mapperService.forRequest().map(createTaskRequest, Task.class);
        taskRepository.save(task);
    }

    @Override
    public void update(UpdateTaskRequest updateTaskRequest) {
        taskRepository.findById(updateTaskRequest.getId()).orElseThrow(() -> new RuntimeException("Task not found: " + updateTaskRequest.getId() ));
        Task task = mapperService.forRequest().map(updateTaskRequest, Task.class);
        taskRepository.save(task);
    }

    @Override
    public TaskResponse getById(int id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found: " + id));
        return mapperService.forResponse().map(task, TaskResponse.class);
    }

    @Override
    public List<TaskResponse> getAll() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(task -> mapperService.forResponse().map(task, TaskResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found: " +id));
        taskRepository.deleteById(id);

    }
}
