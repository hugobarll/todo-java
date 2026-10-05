package com.hugobarll.todo_app.services;

import com.hugobarll.todo_app.entities.Task;
import com.hugobarll.todo_app.repositories.TaskRepository;
import com.hugobarll.todo_app.services.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> obj = taskRepository.findById(id);
        return obj.orElseThrow(() -> new TaskNotFoundException(id));
    }

   public Task create(Task task) {
        return taskRepository.save(task);
   }

   public void complete(Long id) {
        Task obj = findById(id);
        obj.setDone(true);
        taskRepository.save(obj);
   }

   public void deleteById(Long id) {
        findById(id);
        taskRepository.deleteById(id);
   }
}
