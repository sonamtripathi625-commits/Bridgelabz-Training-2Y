package Level2;

import java.util.Scanner;

public class Reverse {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            String num = sc.next();
            int len = num.length();

            int[] digits = new int[len];
            int[] rev = new int[len];

            for (int i = 0; i < len; i++) {
                digits[i] = num.charAt(i) - '0';
                rev[i] = num.charAt(len - 1 - i) - '0';
            }

            System.out.print("Reversed array: ");
            for (int d : rev) System.out.print(d + " ");
        }
    }

