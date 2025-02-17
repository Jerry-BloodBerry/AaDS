import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Selection sort:");
        var nums = new Comparable[]{1, 7, 5, 3, 9};
        SelectionSort.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("\nInsertion sort:");
        nums = new Comparable[]{3, 1, 5, 7, 9};
        InsertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("\nShell sort:");
        nums = new Comparable[]{3, 1, 5, 7, 9};
        ShellSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}