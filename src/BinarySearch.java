public class BinarySearch {

    private static void execute(int[] input, int target) {
        int first = 0;
        int last = input.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;

            if (input[mid] == target) {
                System.out.println("The target is in the position " + mid);
                return;
            } else if (input[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        System.out.println("The target is not in the list");
    }

    public static void main(String[] args) {
        int input[] =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;

        execute(input, target);
    }
}
