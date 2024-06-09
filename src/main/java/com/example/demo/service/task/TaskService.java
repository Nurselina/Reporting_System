package com.example.demo.service.task;

import com.example.demo.controller.task.request.CreateTaskRequest;
import com.example.demo.controller.task.request.UpdateTaskRequest;
import com.example.demo.controller.task.response.TaskResponse;

import java.util.List;

public interface TaskService {

    void create (CreateTaskRequest createTaskRequest);

    void update (UpdateTaskRequest updateTaskRequest);

    TaskResponse getById(int id);

    List<TaskResponse> getAll();

    void delete(int id);
}
