import java.util.Scanner;

public class Q9_UppercaseCompare {
    static String toUpperCaseCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') ch = (char)(ch - 32);
            result.append(ch);
        }
        return result.toString();
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String text = sc.nextLine();
        String custom = toUpperCaseCustom(text);
        String builtIn = text.toUpperCase();
        System.out.println("User-defined uppercase: " + custom);
        System.out.println("Built-in uppercase: " + builtIn);
        System.out.println("Both are same: " + compareStrings(custom, builtIn));
    }
}
