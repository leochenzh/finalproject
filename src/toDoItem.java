public class toDoItem implements Comparable<toDoItem>{
    public String content;
    public String deadline;
    public String urgency;
    public boolean isDone;
    public toDoItem next;

    public toDoItem(String content, String deadline, String urgency){
        this.content = content;
        this.deadline = deadline;
        this.urgency = urgency;
        this.isDone = false;
        this.next = null;
    }

    @Override
    public int compareTo(toDoItem other) {
        if(this.isDone && !other.isDone) {
            return 1;
        }
        if (!this.isDone && other.isDone) {
            return -1;
        }
        return urgencyValue(this.urgency) - urgencyValue(other.urgency);
    }

    private int urgencyValue(String urgency) {
        if ("red".equals(urgency)) return 1;
        if ("yellow".equals(urgency)) return 2;
        if ("green".equals(urgency)) return 3;
        return 4;
    }
}
