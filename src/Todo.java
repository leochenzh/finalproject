import java.util.Scanner;

public class Todo {
    private toDoItem first;

    private class toDoItem{
        private String content;
        private String deadline;
        private String urgency;
        private boolean isDone;
        private toDoItem next;

         private toDoItem(String content, String deadline, String urgency){
            this.content = content;
            this.deadline = deadline;
            this.urgency = urgency;
            this.isDone = false;
            this.next = null;
        }
    }

    public void add(String content, String deadline, String urgency){
        toDoItem newItem = new toDoItem(content, deadline, urgency);
        if (first == null){
            first = newItem;
        } else {
            toDoItem current = first;
            while (current.next != null){
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public void delete(int index){
        if (first == null || index < 1){
            return;
        }
        if (index == 1){
            first = first.next;
            return;
        }
        toDoItem current = first;
        int count = 1;
        while (current.next != null && count < index -1){
            current = current.next;
            count ++;
        }
        if (current.next != null){
            current.next = current.next.next;
        }


    }


}
