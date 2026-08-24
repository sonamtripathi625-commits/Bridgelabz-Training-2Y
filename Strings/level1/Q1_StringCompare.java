import java.util.Scanner;

public class Q1_StringCompare {
    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = sc.next();
        System.out.print("Enter second string: ");
        String second = sc.next();

        boolean userResult = compareStrings(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("charAt() comparison: " + userResult);
        System.out.println("equals() comparison: " + builtInResult);
        System.out.println("Both results are same: " + (userResult == builtInResult));
    }
}
