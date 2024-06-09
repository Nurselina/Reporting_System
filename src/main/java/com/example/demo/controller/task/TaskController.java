package com.example.demo.controller.task;

import com.example.demo.controller.task.request.CreateTaskRequest;
import com.example.demo.controller.task.request.UpdateTaskRequest;
import com.example.demo.controller.task.response.TaskResponse;
import com.example.demo.service.task.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public void createTask(@RequestBody @Valid CreateTaskRequest createTaskRequest){
        taskService.create(createTaskRequest);
    }

    @PutMapping
    public void updateTask(@RequestBody @Valid UpdateTaskRequest updateTaskRequest){
        taskService.update(updateTaskRequest);
    }

    @GetMapping("/{id}")
    public TaskResponse getByIdTask(@PathVariable int id){
        return taskService.getById(id);
    }

    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return taskService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.delete(id);
    }
}
