#Week 2 - Question 1
public class App {
    public static void main(String[] args) {
        for (int i = Integer.parseInt(args[0]); i < Integer.parseInt(args[1]) + 1; i++) {
            System.out.println(i);
        }
    }
}