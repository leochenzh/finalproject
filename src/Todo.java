import stdlib.StdOut;


public class toDo {
    private toDoItem first;

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

    public void markDone(int index){
        toDoItem current = first;
        int count = 1;
        while (current != null){
            if (count == index){
                if (current.isDone){
                    StdOut.println("Event already marked as done");
                } else {
                    current.isDone = true;
                }
                return;
            }
            current = current.next;
            count++;
        }
    }

    private int getSize(){
        int count = 0;
        toDoItem current = first;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void sort() {
        int size = getSize();
        if (size <= 1) return;

        toDoItem[] a = new toDoItem[size];
        toDoItem current = first;
        for (int i = 0; i < size; i++) {
            a[i] = current;
            current = current.next;
        }
        mergeSort.sort(a);
        first = a[0];
        for (int i = 0; i < size - 1; i++) {
            a[i].next = a[i + 1];
        }
        a[size - 1].next = null;
    }

    public void printList() {
        toDoItem current = first;
        int index = 1;
        while (current != null) {
            if (!current.content.isBlank()) {
                String status;
                if (current.isDone) {
                    status = "X";
                } else {
                    status = " ";
                }

                StdOut.println(index + ". [" + status + "] " +
                        current.content + ", Due: " + current.deadline +
                        ", Urgency: " + current.urgency);
            }
            current = current.next;
            index++;
        }
    }
}
