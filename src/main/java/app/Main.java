package app;

import services.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1 - Add task");
            System.out.println("2 - List tasks");
            System.out.println("3 - Change status");
            System.out.println("4 - Delete task");
            System.out.println("5 - Exit");
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
                System.out.println("All tasks:");
                taskManager.listTasks();
                System.out.println();
            }
            else if (option == 3) {
                System.out.print("Enter the id to update the Task: ");
                int id = sc.nextInt();
                sc.nextLine();
                taskManager.completeTask(id);
                System.out.println("Task completed");
                System.out.println();
            }

            if (option == 5) {
                break;
            }
        }

        sc.close();
    }
}
