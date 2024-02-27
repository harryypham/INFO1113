#Week 2 - Question 3
public class App {
    public static void main(String[] args) {
        int[] array = { 1, 1, 5, 5, 5, 3, 8, 1 };
        boolean result = contains(array, 9);
        System.out.println(result);
    }

    public static boolean contains(int[] a, int element) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                return true;
            }
        }
        return false;
    }
}