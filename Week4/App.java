//Week 4 - Question 1
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> a = new ArrayList<String>();
        while (sc.hasNextLine()) {
            a.add(sc.nextLine());
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        sc.close();
    }

}
