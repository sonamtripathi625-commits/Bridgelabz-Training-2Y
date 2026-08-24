import java.util.Scanner;

public class Q2_SubstringCompare {
    static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) result.append(text.charAt(i));
        return result.toString();
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid index range.");
            return;
        }

        String custom = createSubstring(text, start, end);
        String builtIn = text.substring(start, end);
        System.out.println("User-defined substring: " + custom);
        System.out.println("Built-in substring: " + builtIn);
        System.out.println("Both are same: " + compareStrings(custom, builtIn));
    }
}
