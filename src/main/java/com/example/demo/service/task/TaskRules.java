package com.example.demo.service.task;

import com.example.demo.core.exception.AlreadyExistsException;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.exception.type.AlreadyExistsExceptionType;
import com.example.demo.core.exception.type.NotFoundExceptionType;
import com.example.demo.repository.task.TaskRepository;
import com.example.demo.service.businessRulesAbstract.BaseItemRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskRules implements BaseItemRules {

    private final TaskRepository taskRepository;

    @Override
    public void existsByName(String title) {
      if (taskRepository.existsByTitle(title)){
          throw new AlreadyExistsException(AlreadyExistsExceptionType.TASK_ALREADY_EXISTS);
      }
    }

    @Override
    public void existsByNameAndIdNot(String title, int id) {
     if (taskRepository.existsByTitleAndIdNot(title,id)){
         throw new AlreadyExistsException(AlreadyExistsExceptionType.TASK_ALREADY_EXISTS);
     }
    }

    @Override
    public void checkDataList(List<?> list) {
     if (list.isEmpty()){
         throw new NotFoundException(NotFoundExceptionType.TASK_LIST_NOT_FOUND);
     }
    }

    @Override
    public String fixName(String title) {
        return title.trim().toLowerCase();

    }

    @Override
    public void checkData(int id) {
        if (!taskRepository.existsById(id)){
            throw new NotFoundException(NotFoundExceptionType.TASK_DATA_NOT_FOUND);
        }
    }
}
