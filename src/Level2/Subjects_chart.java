package Level2;

import java.util.Scanner;

public class Subjects_chart {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter students count: ");
            int n = sc.nextInt();

            double[] pct = new double[n];
            char[] grade = new char[n];

            for (int i = 0; i < n; i++) {
                System.out.print("S" + (i + 1) + " (P C M): ");
                int p = sc.nextInt(), c = sc.nextInt(), m = sc.nextInt();

                if (p < 0 || c < 0 || m < 0) { System.out.println("Invalid!"); i--; continue; }

                pct[i] = (p + c + m) / 3.0;
                grade[i] = pct[i] >= 80 ? 'A' : pct[i] >= 70 ? 'B' : pct[i] >= 60 ? 'C' : pct[i] >= 50 ? 'D' : 'F';
            }

            for (int i = 0; i < n; i++)
                System.out.println("S" + (i + 1) + " -> Pct: " + (int)pct[i] + "% | Grade: " + grade[i]);
        }
    }

