import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class toDoItem {
    String task;
    String deadline;
    String urgency;
    boolean isDone;
    toDoItem next;

    public toDoItem(String task, String deadline, String urgency) {
        this.task = task;
        this.deadline = deadline;
        this.urgency = urgency;
        this.isDone = false;
        this.next = null;
    }

    public LocalDate getDeadlineDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return LocalDate.parse(this.deadline, formatter);
    }
}
