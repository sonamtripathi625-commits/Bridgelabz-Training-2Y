import java.util.Scanner;

public class Maximum_number {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double[] arr = new double[10];
            double total = 0.0;
            int count = 0;


            while (true) {
                if (count == 10) break;
                System.out.print("Enter number: ");
                double num = sc.nextDouble();
                if (num <= 0) break;

                arr[count++] = num;
            }

            System.out.println("\nNumbers entered:");
            for (int i = 0; i < count; i++) {
                System.out.println(arr[i]);
                total += arr[i];
            }

            System.out.println("Total: " + total);
        }
    }

