import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import stdlib.StdOut;
import stdlib.StdIn;

public class toDoUI {
    public void run() {
        toDo tasks = new toDo();
        while (true) {
            StdOut.println("\nWhat would you like to do?");
            StdOut.println("1. Add task");
            StdOut.println("2. Delete task");
            StdOut.println("3. Mark task as done");
            StdOut.println("4. Show all tasks");
            StdOut.println("5. Sort by urgency");
            StdOut.println("6. Sort by deadline");
            StdOut.println("7. Exit");
            StdOut.print("enter number: ");

            int option = Integer.parseInt(StdIn.readLine());

            if (option == 1) {
                StdOut.print("task: ");
                String task = StdIn.readLine();
                if (task.isBlank()) throw new IllegalArgumentException("Task cannot be empty.");

                StdOut.print("deadline (MM-DD-YYYY): ");
                String deadline = StdIn.readLine();
                if (deadline.isBlank()) throw new IllegalArgumentException("Deadline cannot be empty.");
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                    LocalDate.parse(deadline, formatter); // validate format
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Deadline must be in MM-DD-YYYY format.");
                }

                StdOut.print("urgency (R, Y, G): ");
                String urgency = StdIn.readLine();
                if (!urgency.equals("R") && !urgency.equals("Y") && !urgency.equals("G"))
                    throw new IllegalArgumentException("Urgency must be R, Y, or G.");

                tasks.add(task, deadline, urgency);
            } else if (option == 2) {
                StdOut.print("Task number to delete: ");
                int index = Integer.parseInt(StdIn.readLine());
                tasks.delete(index);
            } else if (option == 3) {
                StdOut.print("Task number to mark as done: ");
                int index = Integer.parseInt(StdIn.readLine());
                tasks.markDone(index);
            } else if (option == 4) {
                tasks.printList();
            } else if (option == 5) {
                tasks.sort();
                StdOut.println("Tasks sorted by urgency.");
            } else if (option == 6) {
                tasks.sortByDeadline();
                StdOut.println("Tasks sorted by deadline.");
            } else if (option == 7) {
                StdOut.println("Goodbye!");
                break;
            } else {
                StdOut.println("Invalid option.");
            }
        }
    }
}
