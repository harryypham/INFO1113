//Week 4 - Question 2
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (map.containsKey(line.charAt(i))) {
                    map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                } else {
                    map.put(line.charAt(i), 1);
                }
            }
            System.out.print("{");
            int idx = 0;
            for (char key : map.keySet()) {
                if (idx == 0) {
                    System.out.printf("%c=%d", key, map.get(key));
                    idx += 1;
                    continue;
                }
                System.out.printf(", %c=%d", key, map.get(key));
            }
            System.out.print("}\n");
        }
        sc.close();
    }

}
