package com.example.demo.mapper1;

import com.example.demo.controller.task.request.CreateTaskRequest;
import com.example.demo.controller.task.response.TaskResponse;
import com.example.demo.repository.task.Task;

public class TaskMapper {

    public static Task toEntity (CreateTaskRequest request){
        if(request == null){
            return null;
        }

        return Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus())
                .createdDate(request.getCreatedDate())
                .build();

    }
    public static TaskResponse toResponse (Task task){
        if (task == null){
            return null;
        }

        return TaskResponse.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdDate(task.getCreatedDate())
                .build();
    }


}
