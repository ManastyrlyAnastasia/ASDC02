import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        String fileName = "C:/Users/ACER/Desktop/настя/2 курс/ASDC/primer1/Competitors.csv";
        String[][] data = readDataFromFile(fileName);
        int keyIndex = 0; // номер столбца с ключом
        bubbleSort(data, keyIndex);
        printData(data);
    }

 
    public static String[][] readDataFromFile(String fileName) {
        String[][] data = new String[0][0];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                data = Arrays.copyOf(data, data.length + 1);
                data[data.length - 1] = row;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void bubbleSort(String[][] data, int keyIndex) {
        int n = data.length;
        int comparisons = 0;
        int swaps = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j][keyIndex].compareTo(data[j + 1][keyIndex]) > 0) {
                    String[] temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swaps++;
                }
                comparisons++;
            }
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Theoretical complexity: O(n^2)");
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }

    // Вывод отсортированных данных
    public static void printData(String[][] data) {
        for (String[] row : data) {
            for (String item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
