
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    /**
     * Sorts a list in ascending order
     * Returns a new sorted list
     *
     * Divide: Find the midpoint of the list and divide into sublists
     * Conquer: Recursively sort the sublists created in previous step
     * Combine: Merge the sorted sublists created in the previous step
     *
     * @param list
     * @return a new sorted list
     */
    public static List<Integer> mergeSort(List<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }

        int midpoint = list.size() / 2;
        List<Integer> leftHalf = list.subList(0, midpoint);
        List<Integer> rightHalf = list.subList(midpoint, list.size());

        List<Integer> left = mergeSort(leftHalf);
        List<Integer> right = mergeSort(rightHalf);

        return merge(left, right);
    }

    /**
     * Merges two lists (arrays), sorting them in the process
     * Returns a new merged list
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> l = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                l.add(left.get(i));
                i++;
            } else {
                l.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            l.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            l.add(right.get(j));
            j++;
        }

        return l;
    }

    public static void main(String[] args) {
        List<Integer> alist = Arrays.asList(90, 38, 22, 91);
        List<Integer> sortedList = mergeSort(alist);
        System.out.println(verifySorted(sortedList));
    }

    private static boolean verifySorted(List<Integer> list) {
        int n = list.size();

        if (n == 0 || n == 1) {
            return true;
        }

        return list.get(0) < list.get(1) && verifySorted(list.subList(1, n));
    }
}
