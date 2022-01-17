public class LinearSearch {

    private static void execute(int[] list, int target) {
        for(int i = 0; i < list.length; i++) {
            if(list[i] == target) {
                System.out.println("The number is in the index: " + i);
                return;
            }
        }
        System.out.println("This number is not in the list");
    }

    public static void main(String[] args) {
        int list[] =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 12;

        execute(list, target);
    }
}
