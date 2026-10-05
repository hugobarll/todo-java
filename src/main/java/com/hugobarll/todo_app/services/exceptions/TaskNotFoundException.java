package com.hugobarll.todo_app.services.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task not found. Id " + id);
    }
}
