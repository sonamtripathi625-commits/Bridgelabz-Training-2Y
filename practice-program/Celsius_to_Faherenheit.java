import java.util.Scanner;

public class Celsius_to_Faherenheit {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter temperature in Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9.0 / 5.0);

            // Print the result
            System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");

            scanner.close();
        }
    }

