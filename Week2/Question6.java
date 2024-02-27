#Week 2 - Question 6
import java.util.*;

public class App {
    public static void main(String[] args) {
        int[] x = { 3, 2, 7 };
        int[] y = { 3, 8, 9 };
        int[] result = union(x, y);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] union(int[] x, int[] y) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < x.length; i++) {
            s.add(x[i]);
        }
        for (int i = 0; i < y.length; i++) {
            s.add(y[i]);
        }
        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}