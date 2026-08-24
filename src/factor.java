import java.util.Scanner;

public class factor {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number: ");
            int num = sc.nextInt();

            int maxFactor = 10, index = 0;
            int[] factors = new int[maxFactor];

            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    if (index == maxFactor) {
                        maxFactor *= 2;
                        int[] temp = new int[maxFactor];
                        System.arraycopy(factors, 0, temp, 0, factors.length);
                        factors = temp;
                    }
                    factors[index++] = i;
                }
            }

            System.out.print("Factors: ");
            for (int i = 0; i < index; i++) System.out.print(factors[i] + " ");
        }
    }

