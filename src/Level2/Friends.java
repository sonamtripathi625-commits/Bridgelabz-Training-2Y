import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age & height for " + names[i] + ": ");
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int minAgeIdx = 0, maxHeightIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIdx]) minAgeIdx = i;
            if (height[i] > height[maxHeightIdx]) maxHeightIdx = i;
        }

        System.out.println("Youngest: " + names[minAgeIdx] + " (" + age[minAgeIdx] + ")");
        System.out.println("Tallest: " + names[maxHeightIdx] + " (" + height[maxHeightIdx] + ")");
    }
}