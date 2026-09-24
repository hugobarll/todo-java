package app;

import exceptions.TaskFileException;
import exceptions.TaskNotFoundException;
import services.TaskManager;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();

        String filePath = "data/tasks.txt";


        try {
            taskManager.loadTasks(filePath);
            System.out.println("Progress loaded");
        }
        catch (TaskFileException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Your progress will be save when you exit");

        while (true) {
            try {
                System.out.println("1 - Add task");
                System.out.println("2 - List tasks");
                System.out.println("3 - Change status");
                System.out.println("4 - Delete task");
                System.out.println("5 - Save progress");
                System.out.println("6 - Exit");
                System.out.print("Enter an option: ");
                int option = sc.nextInt();
                sc.nextLine();
                System.out.println();

                if (option == 1) {
                    System.out.print("Enter the task: ");
                    String description = sc.nextLine();
                    taskManager.addTask(description);
                    System.out.println();
                }

                else if (option == 2) {
                    taskManager.listTasks();
                    System.out.println();
                }

                else if (option == 3) {
                    System.out.print("Enter the id to update the task: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    taskManager.completeTask(id);
                    System.out.println("Task completed");
                    System.out.println();
                }

                else if (option == 4) {
                    System.out.print("Enter the id to remove the task: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    taskManager.deleteTask(id);
                    System.out.println("Task removed");
                    System.out.println();
                }

                else if (option == 5) {
                    taskManager.saveTasks(filePath);
                    System.out.println("Progress saved");
                    System.out.println();
                }

                else if (option == 6) {
                    break;
                }

                else {
                    System.out.println("Invalid option");
                    System.out.println();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("The input is not valid");
                System.out.println();
                sc.nextLine();
            }
            catch (TaskNotFoundException | TaskFileException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        taskManager.saveTasks(filePath);
        System.out.println("Progress saved!");
        sc.close();
    }
}
