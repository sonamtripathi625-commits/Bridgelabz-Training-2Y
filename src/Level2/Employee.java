package Level2;

import java.util.Scanner;

public class Employee {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double[] sal = new double[10], yos = new double[10];
            double[] bonus = new double[10], newSal = new double[10];
            double totOld = 0, totBonus = 0, totNew = 0;

            for (int i = 0; i < 10; i++) {
                System.out.print("Emp " + (i + 1) + " Sal & YOS: ");
                sal[i] = sc.nextDouble();
                yos[i] = sc.nextDouble();
                if (sal[i] <= 0 || yos[i] < 0) { System.out.println("Invalid!"); i--; }
            }

            for (int i = 0; i < 10; i++) {
                bonus[i] = sal[i] * (yos[i] > 5 ? 0.05 : 0.02);
                newSal[i] = sal[i] + bonus[i];
                totOld += sal[i]; totBonus += bonus[i]; totNew += newSal[i];
            }

            System.out.println("Total Old: " + totOld + " | Bonus: " + totBonus + " | New: " + totNew);
        }
    }

