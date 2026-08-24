import java.util.Scanner;

public class Q5_StringIndexOutOfBoundsException {
    static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 1));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled: " + e.getMessage());
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
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Generated StringIndexOutOfBoundsException: " + e.getMessage());
        }
        handleException(text);
    }
}
