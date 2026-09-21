package services;

import entities.Task;

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
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void completeTask(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setDone(true);
            }
        }
    }
}
