import stdlib.StdOut;

public class toDo {
    toDoItem head;

    public void add(String task, String deadline, String urgency) {
        toDoItem newItem = new toDoItem(task, deadline, urgency);
        if (head == null) head = newItem;
        else {
            toDoItem current = head;
            while (current.next != null) current = current.next;
            current.next = newItem;
        }
    }

    public void delete(int index) {
        if (head == null || index < 1) return;
        if (index == 1) {
            head = head.next;
            return;
        }
        toDoItem current = head;
        for (int i = 1; current.next != null && i < index - 1; i++) current = current.next;
        if (current.next != null) current.next = current.next.next;
    }

    public void markDone(int index) {
        toDoItem current = head;
        for (int i = 1; current != null && i < index; i++) current = current.next;
        if (current != null) current.isDone = true;
    }

    public void printList() {
        toDoItem current = head;
        int index = 1;
        while (current != null) {
            StdOut.println(index + ". [" + (current.isDone ? "X" : " ") + "] " + current.task +
                    ", Deadline: " + current.deadline + ", Urgency: " + current.urgency);
            current = current.next;
            index++;
        }
    }

    public void sort() {
        int size = getSize();
        if (size < 2) return;

        toDoItem[] arr = toArray(size);
        mergeSort.sort(arr);
        rebuildFromArray(arr);
    }

    public void sortByDeadline() {
        int size = getSize();
        if (size < 2) return;

        toDoItem[] arr = toArray(size);
        mergeSort.sortByDeadline(arr);
        rebuildFromArray(arr);
    }

    private int getSize() {
        int count = 0;
        toDoItem current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private toDoItem[] toArray(int size) {
        toDoItem[] arr = new toDoItem[size];
        toDoItem current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current;
            current = current.next;
        }
        return arr;
    }

    private void rebuildFromArray(toDoItem[] arr) {
        head = arr[0];
        toDoItem current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = arr[i];
            current = current.next;
        }
        current.next = null;
    }
}
