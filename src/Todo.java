public class mergeSort {

    // Sorts by urgency and isDone
    public static void sort(toDoItem[] a) {
        toDoItem[] aux = new toDoItem[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(toDoItem[] a, toDoItem[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    // Merges by isDone first, then urgency
    private static void merge(toDoItem[] a, toDoItem[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (!aux[i].isDone && aux[j].isDone) a[k] = aux[i++];
            else if (aux[i].isDone && !aux[j].isDone) a[k] = aux[j++];
            else if (urgencyVal(aux[j].urgency) < urgencyVal(aux[i].urgency)) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // Converts urgency code to priority number
    private static int urgencyVal(String urgency) {
        return switch (urgency) {
            case "R" -> 1;
            case "Y" -> 2;
            case "G" -> 3;
            default -> 4;
        };
    }

    // Sorts by deadline and isDone
    public static void sortByDeadline(toDoItem[] a) {
        toDoItem[] aux = new toDoItem[a.length];
        sortByDeadline(a, aux, 0, a.length - 1);
    }

    private static void sortByDeadline(toDoItem[] a, toDoItem[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortByDeadline(a, aux, lo, mid);
        sortByDeadline(a, aux, mid + 1, hi);
        mergeByDeadline(a, aux, lo, mid, hi);
    }

    // Merges by isDone first, then by deadline (earlier first)
    private static void mergeByDeadline(toDoItem[] a, toDoItem[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (!aux[i].isDone && aux[j].isDone) a[k] = aux[i++];
            else if (aux[i].isDone && !aux[j].isDone) a[k] = aux[j++];
            else if (aux[i].getDeadlineDate().isBefore(aux[j].getDeadlineDate())) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
