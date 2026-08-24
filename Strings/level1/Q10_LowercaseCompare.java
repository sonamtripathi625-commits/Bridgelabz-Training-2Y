import java.util.Scanner;

public class Q10_LowercaseCompare {
    static String toLowerCaseCustom(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
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
        String custom = toLowerCaseCustom(text);
        String builtIn = text.toLowerCase();
        System.out.println("User-defined lowercase: " + custom);
        System.out.println("Built-in lowercase: " + builtIn);
        System.out.println("Both are same: " + compareStrings(custom, builtIn));
    }
}
