package com.hugobarll.todo_app.repositories;

import com.hugobarll.todo_app.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
