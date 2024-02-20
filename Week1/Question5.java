//Week1 - Question 5
public class App {
    public static void main(String[] args) {
        int grade = Integer.parseInt(args[0]);
        if (grade >= 85) {
            System.out.println("High Distinction");
        } else if (grade >= 75) {
            System.out.println("Distinction"); 
        } else if (grade >= 65) {
            System.out.println("Credit");
        } else if (grade >= 50) {
            System.out.println("Pass");
        } else if (grade >= 0) {
            System.out.println("Fail");
        }

    }
}