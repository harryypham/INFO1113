//Week 3 - Question 3

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        File f = new File("test.in");
        try {
            Scanner sc = new Scanner(f);
            String line;
            ArrayList<Athlete> athletes = new ArrayList<>();
            int i = 0;
            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] arr = line.trim().split(", ", 0);
                if (arr.length != 2) {
                    continue;
                }
                athletes.add(new Athlete(arr[0], Double.parseDouble(arr[1])));
                i += 1;
            }
            sc.close();
            Collections.sort(athletes, new Comparator<Athlete>() {
                public int compare(Athlete a1, Athlete a2) {
                    return Double.compare(a1.getTime(), a2.getTime());
                }
            });
            for (i = 0; i < athletes.size(); i++) {
                System.out.printf("%s, %f\n", athletes.get(i).getName(), athletes.get(i).getTime());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not founded!");
        }

    }

}
