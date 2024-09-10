package com.example.demo.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    boolean existsByTitle(String title);

    boolean existsByTitleAndIdNot(String title, int id);

    boolean existsById(int id);

}
