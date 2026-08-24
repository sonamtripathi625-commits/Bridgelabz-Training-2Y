import java.util.Scanner;

public class Reverse_Number {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            int n = sc.nextInt();

            int reversedNum = 0;

            // Code negative numbers ko bhi handle karega
            while (n != 0) {
                int lastDigit = n % 10;
                reversedNum = (reversedNum * 10) + lastDigit;
                n = n / 10;
            }

            System.out.println("Reversed Number: " + reversedNum);

            sc.close();
        }
    }

