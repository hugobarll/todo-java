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
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.print("Enter the task: ");
                String description = sc.nextLine();
                taskManager.addTask(description);
            }

            if (option == 5) {
                break;
            }
        }

        sc.close();
    }
}
