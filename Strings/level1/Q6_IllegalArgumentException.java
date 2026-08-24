import java.util.Scanner;

public class Q6_IllegalArgumentException {
    static void generateException(String text) {
        System.out.println(text.substring(text.length(), 1));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.substring(text.length(), 1));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Generated RuntimeException: " + e.getMessage());
        }
        handleException(text);
    }
}
