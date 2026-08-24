public class Q4_NullPointerException {
    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Demonstrating the exception (without stopping the program):");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Generated NullPointerException: " + e.getMessage());
        }
        System.out.println("Now handling it:");
        handleException();
    }
}
