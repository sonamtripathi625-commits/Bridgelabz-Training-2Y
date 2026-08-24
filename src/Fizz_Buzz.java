import java.util.Scanner;

public class Fizz_Buzz {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a positive number: ");
            int num = sc.nextInt();

            if (num < 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }


            String[] result = new String[num + 1];


            for (int i = 0; i <= num; i++) {
                if (i == 0) {
                    result[i] = "0";
                } else if (i % 3 == 0 && i % 5 == 0) {
                    result[i] = "FizzBuzz";
                } else if (i % 3 == 0) {
                    result[i] = "Fizz";
                } else if (i % 5 == 0) {
                    result[i] = "Buzz";
                } else {
                    result[i] = String.valueOf(i);
                }
            }


            for (int i = 0; i <= num; i++) {
                System.out.println("Position " + i + " = " + result[i]);
            }
        }
    }

