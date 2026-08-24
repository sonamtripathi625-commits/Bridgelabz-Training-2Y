package Level2;

import java.util.Scanner;

public class frequency {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            String num = sc.next();

            int[] freq = new int[10];

            // Digits array mein count store karna
            for (char c : num.toCharArray()) {
                if (Character.isDigit(c)) {
                    freq[c - '0']++;
                }
            }

            // Frequency display karna
            for (int i = 0; i < 10; i++) {
                if (freq[i] > 0) System.out.println("Digit " + i + ": " + freq[i]);
            }
        }
    }

