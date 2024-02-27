#Week 2 - Question 5
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        int[] array = { 1, 1, 5, 6, 5, 3, 8, 1, 9, 2, 8 };
        int result = countDuplicates(array);
        System.out.println(result);
    }

    static int countDuplicates(int[] a) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            int freq = count.containsKey(a[i]) ? count.get(a[i]) : 0;
            count.put(a[i], freq + 1);
        }
        int ans = 0;
        for (int value : count.values()) {
            if (value > 1) {
                ans += 1;
            }
        }
        return ans;
    }
}