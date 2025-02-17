public class SelectionSort {

    public static void sort(Comparable[] items)
    {
        for (int i = 0; i < items.length; i++) {
            int min = i;
            for (int j = i + 1; j < items.length; j++) {
                if (less(items[j], items[min])) {
                    min = j;
                }
            }
            swap(items, i, min);
        }
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
