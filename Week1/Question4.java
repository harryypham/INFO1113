//Week1 - Question 4
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Hi, What's your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        input.close();
        System.out.printf("Hello %s!\n", name);
    }
}