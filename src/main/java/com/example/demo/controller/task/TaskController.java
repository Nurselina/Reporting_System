package com.example.demo.controller.task;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.task.request.CreateTaskRequest;
import com.example.demo.controller.task.request.UpdateTaskRequest;
import com.example.demo.controller.task.response.TaskResponse;
import com.example.demo.service.task.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tasks")
public class TaskController extends BaseController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTaskRequest createTaskRequest){
        taskService.create(createTaskRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateTaskRequest updateTaskRequest){
        taskService.update(updateTaskRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable int id){
        return answer(taskService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(){
        return answer(taskService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        taskService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
