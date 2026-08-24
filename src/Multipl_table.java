import java.util.Scanner;

public class Multipl_table {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Step a: Get input number and define an array of size 10
            System.out.print("Enter a number: ");
            int number = sc.nextInt();
            int[] table = new int[10];

            // Step b: Calculate and store results in the array
            for (int i = 0; i < 10; i++) {
                table[i] = number * (i + 1);
            }

            // Step c: Display the result from the array
            for (int i = 0; i < 10; i++) {
                System.out.println(number + " * " + (i + 1) + " = " + table[i]);
            }
        }
    }
