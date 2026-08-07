import java.util.Scanner;

public class convert_kilometer {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for distance in kilometers
            System.out.print("Enter distance in kilometers: ");
            double kilometers = scanner.nextDouble();

            // Calculate miles using formula: Miles = Kilometers * 0.621371
            double miles = kilometers * 0.621371;

            // Display the result
            System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");

            scanner.close();
        }
    }

