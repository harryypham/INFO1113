#Week 2 - Question 2
public class App {
    static int countVowels(String s) {
        int count = 0;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < s.length(); i++) {
            if (new String(vowels).indexOf(s.charAt(i)) != -1) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "astronaut";
        int count = countVowels(s);
        System.out.println("Number of count: " + count); // 4
    }
}