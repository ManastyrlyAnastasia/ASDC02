import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        String fileName = "C:/Users/ACER/Desktop/настя/2 курс/ASDC/primer1/Competitors.csv";
        String[] competitors = readCompetitorsFromFile(fileName);
        sortCompetitorsByCategory(competitors);
        for (String competitor : competitors) {
            System.out.println(competitor);
        }
    }

    public static void sortCompetitorsByCategory(String[] competitors) {
        int comparisons = 0;
        int swaps = 0;
        long startTime = System.nanoTime();

        for (int i = 0; i < competitors.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < competitors.length; j++) {
                comparisons++;
                if (competitors[j].split(" ")[4].compareTo(competitors[minIndex].split(" ")[4]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swaps++;
                String temp = competitors[i];
                competitors[i] = competitors[minIndex];
                competitors[minIndex] = temp;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Theoretical time complexity: O(n^2)");
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
        System.out.println("Execution time: " + duration + "ms");
    }

    public static String[] readCompetitorsFromFile(String fileName) {
        String[] competitors = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            competitors = reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return competitors;
    }
}
