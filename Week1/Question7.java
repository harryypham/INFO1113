//Week1 - Question 7
public class App {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        if (num1 >= num2 && num1 >= num3) {
            if (num2 >= num3) {
                System.out.printf("%d %d %d\n", num1, num2, num3);
            } else {
                System.out.printf("%d %d %d\n", num1, num3, num2);
            } 
        } else if (num2 >= num3 && num2 >= num1) {
            if (num3 >= num1) {
                System.out.printf("%d %d %d\n", num2, num3, num1);
            } else {
                System.out.printf("%d %d %d\n", num2, num1, num3);
            }
        } else {
            if (num1 >= num2) {
                System.out.printf("%d %d %d\n", num3, num1, num2);
            } else {
                System.out.printf("%d %d %d\n", num3, num2, num1);
            }
        }
    }
}