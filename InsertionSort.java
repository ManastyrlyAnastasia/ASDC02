import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {
       
        File file = new File("C:/Users/ACER/Desktop/настя/2 курс/ASDC/primer1/Competitors.csv");
        Scanner scanner = new Scanner(file);
        String[] data = new String[1000];
        int count = 0;
        while (scanner.hasNextLine()) {
            data[count++] = scanner.nextLine();
        }
        scanner.close();

        for (int i = 1; i < count; i++) {
            String key = getKey(data[i]);
            int j = i - 1;
            while (j >= 0 && getKey(data[j]).compareTo(key) > 0) {
                String temp = data[j];
                data[j] = data[j+1];
                data[j+1] = temp;
                j--;
            }
        }

     
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    private static String getKey(String str) {
       
        return str;
    }
}
