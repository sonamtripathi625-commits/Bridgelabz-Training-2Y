import java.util.Scanner;

public class Q7_NumberFormatException {
    static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        try {
            generateException(text);
        } catch (NumberFormatException e) {
            System.out.println("Generated NumberFormatException: " + e.getMessage());
        }
        handleException(text);
    }
}
