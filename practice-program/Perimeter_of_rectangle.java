import java.util.Scanner;

public class Perimeter_of_rectangle {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for length and width
            System.out.print("Enter the length of the rectangle: ");
            double length = scanner.nextDouble();

            System.out.print("Enter the width of the rectangle: ");
            double width = scanner.nextDouble();

            // Calculate perimeter using formula: 2 * (length + width)
            double perimeter = 2 * (length + width);

            // Display the result
            System.out.println("The perimeter of the rectangle is: " + perimeter);

            scanner.close();
        }
    }

