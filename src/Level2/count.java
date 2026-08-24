package Level2;

import java.util.Scanner;

public class count {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            long num = Math.abs(sc.nextLong());

            // Count digits & create digits array
            int count = String.valueOf(num).length();
            int[] digits = new int[count];
            long temp = num;
            for (int i = count - 1; i >= 0; i--) {
                digits[i] = (int)(temp % 10);
                temp /= 10;
            }

            // Frequency count using digits array
            int[] freq = new int[10];
            for (int d : digits) freq[d]++;

            // Display frequency
            for (int i = 0; i < 10; i++) {
                if (freq[i] > 0) System.out.println("Digit " + i + ": " + freq[i]);
            }
        }
    }

