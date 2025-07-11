import stdlib.StdOut;
import stdlib.StdIn;

public class toDoUI {
    private toDo todoList;

    public toDoUI() {
        todoList = new toDo();
    }

    public void run() {
        while (true) {
            StdOut.println("\nchoose an action:");
            StdOut.println("1. add task");
            StdOut.println("2. delete task");
            StdOut.println("3. mark task as done");
            StdOut.println("4. show all tasks");
            StdOut.println("5. sort by urgency");
            StdOut.println("6. exit");
            StdOut.print("enter number: ");
            String input = StdIn.readLine();

            try {
                if (input.equals("1")) {
                    StdOut.print("content: ");
                    String content = StdIn.readLine();
                    if (content.isBlank()) throw new IllegalArgumentException("Content cannot be empty.");

                    StdOut.print("deadline: ");
                    String deadline = StdIn.readLine();
                    if (deadline.isBlank()) throw new IllegalArgumentException("Deadline cannot be empty.");

                    StdOut.print("urgency (red/yellow/green): ");
                    String urgency = StdIn.readLine();
                    if (!(urgency.equals("red") || urgency.equals("yellow") || urgency.equals("green"))) {
                        throw new IllegalArgumentException("Urgency must be either red or yellow or green.");
                    }
                    todoList.add(content, deadline, urgency);

                } else if (input.equals("2")) {
                    StdOut.print("which index want to delete: ");
                    int deleteIndex = Integer.parseInt(StdIn.readLine());
                    todoList.delete(deleteIndex);

                } else if (input.equals("3")) {
                    StdOut.print("index to mark done: ");
                    int doneIndex = Integer.parseInt(StdIn.readLine());
                    todoList.markDone(doneIndex);
                    todoList.printList();

                } else if (input.equals("4")) {
                    todoList.printList();

                } else if (input.equals("5")) {
                    todoList.sort();
                    todoList.printList();
                } else if (input.equals("6")) {
                    return;

                } else {
                    throw new IllegalArgumentException("invalid number");
                }
            } catch (Exception e) {
                StdOut.println("error: " + e.getMessage());
            }
        }
    }

}
