import java.util.Scanner;

public class Prime_number_checker {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            int n = sc.nextInt();

            boolean isPrime = true;

            if (n <= 1) {
                isPrime = false;
            } else {

                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break; // Factor mil gaya, loop roko
                    }
                }
            }

            if (isPrime) {
                System.out.println("Prime");
            } else {
                System.out.println("Not Prime");
            }

            sc.close();
        }
    }

