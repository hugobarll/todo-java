package services;

import entities.Task;
import exceptions.TaskFileException;
import exceptions.TaskNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    private int nextId = 1;

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

    public void saveTasks(String filePath) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Task t : tasks) {
                bw.write(t.getId() + ";" + t.getDescription() + ";" + t.isDone());
                bw.newLine();
            }
        }
        catch (IOException e) {
            throw new TaskFileException("Error saving tasks to file ", e);
        }
    }

    public void loadTasks(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        tasks.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                boolean done = Boolean.parseBoolean(parts[2]);
                tasks.add(new Task(id, description, done));

                if (id >= nextId) {
                    nextId = id + 1;
                }
            }
        }
        catch (IOException e) {
            throw new TaskFileException("Error loading tasks from file ", e);
        }
    }
}
