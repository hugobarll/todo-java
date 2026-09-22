package services;

import entities.Task;
import exceptions.TaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    int nextId = 1;

    public void addTask(String description) {
        Task task = new Task(nextId, description, false);
        nextId++;
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show");
        }
        else {
            System.out.println("All tasks:");
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    public void completeTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setDone(true);
                return;
            }
        }
        throw new TaskNotFoundException("Task not found with id " + id);
    }

    public void deleteTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);

        if (!removed) {
            throw new TaskNotFoundException("Task not found with id " + id);
        }
    }
}
