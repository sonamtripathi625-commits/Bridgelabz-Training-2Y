package Level2;

import java.util.Scanner;

public class BMI {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of persons: ");
            int n = sc.nextInt();

            double[] wt = new double[n], ht = new double[n], bmi = new double[n];
            String[] st = new String[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter weight (kg) & height (m) for P" + (i + 1) + ": ");
                wt[i] = sc.nextDouble();
                ht[i] = sc.nextDouble();

                bmi[i] = wt[i] / (ht[i] * ht[i]);

                if (bmi[i] < 18.5) st[i] = "Underweight";
                else if (bmi[i] < 25.0) st[i] = "Normal";
                else if (bmi[i] < 30.0) st[i] = "Overweight";
                else st[i] = "Obese";
            }

            System.out.println("\nResults:");
            for (int i = 0; i < n; i++) {
                System.out.println("P" + (i + 1) + " -> H: " + ht[i] + "m, W: " + wt[i] + "kg, BMI: " + (int)bmi[i] + ", Status: " + st[i]);
            }
        }
    }


