import java.util.Scanner;

public class Q7_PalindromeThreeWays {
    static boolean palindromeLoop(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean palindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return palindromeRecursive(text, start + 1, end - 1);
    }

    static char[] reverseUsingCharAt(String text) {
        char[] reverse = new char[text.length()];
        for (int i = 0; i < text.length(); i++)
            reverse[i] = text.charAt(text.length() - 1 - i);
        return reverse;
    }

    static boolean palindromeArrays(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseUsingCharAt(text);

        for (int i = 0; i < original.length; i++)
            if (original[i] != reverse[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Logic 1 - Loop: " + palindromeLoop(text));
        System.out.println("Logic 2 - Recursion: " + palindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Logic 3 - Arrays: " + palindromeArrays(text));
    }
}
