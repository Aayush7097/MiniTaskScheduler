import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Task {
    private String title;
    private String description;
    private String deadline; // can be "yyyy-mm-dd" or time
    private boolean isCompleted;

    // Constructor
    public Task(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "[ " + (isCompleted ? "✔" : "✘") + " ] "
                + "Title: " + title
                + (description.isEmpty() ? "" : " | Desc: " + description)
                + (deadline.isEmpty() ? "" : " | Deadline: " + deadline);
    }
}

public class MiniTaskScheduler {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        System.out.println("=====================================");
        System.out.println("   Welcome to Mini Task Scheduler!");
        System.out.println("=====================================");

        do {
            showMenu();
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    markTaskAsCompleted();
                    break;
                case 5:
                    saveTasksToFile();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n========= MENU =========");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Delete a task");
        System.out.println("4. Mark task as completed");
        System.out.println("5. Save tasks to file");
        System.out.println("6. Exit");
        System.out.println("========================");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter task description (optional): ");
        String desc = sc.nextLine();

        System.out.print("Enter task deadline (yyyy-mm-dd) or leave blank: ");
        String deadline = sc.nextLine();

        Task newTask = new Task(title, desc, deadline);
        tasks.add(newTask);
        System.out.println("✅ Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Are you sure you want to delete this task? (y/n): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            tasks.remove(num - 1);
            System.out.println("🗑 Task deleted successfully!");
        } else {
            System.out.println("❌ Deletion canceled.");
        }
    }

    private static void markTaskAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to mark as completed: ");
        int num = sc.nextInt();
        sc.nextLine();

        if (num < 1 || num > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.get(num - 1).markCompleted();
        System.out.println("✅ Task marked as completed!");
    }

    private static void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task t : tasks) {
                writer.write(t.toString());
                writer.newLine();
            }
            System.out.println("💾 Tasks saved to tasks.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
