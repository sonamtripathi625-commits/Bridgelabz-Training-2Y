package Level2;

import java.util.Scanner;

public class Max_digits {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            int num = sc.nextInt();

            int maxDigit = 10, index = 0;
            int[] digits = new int[maxDigit];

            // Store digits in array (max 10)
            while (num != 0) {
                digits[index++] = num % 10;
                num /= 10;
                if (index == maxDigit) break;
            }

            // Find largest & second largest
            int max = -1, secondMax = -1;
            for (int i = 0; i < index; i++) {
                if (digits[i] > max) {
                    secondMax = max;
                    max = digits[i];
                } else if (digits[i] > secondMax && digits[i] != max) {
                    secondMax = digits[i];
                }
            }

            System.out.println("Largest: " + max);
            System.out.println("Second Largest: " + secondMax);
        }
    }

