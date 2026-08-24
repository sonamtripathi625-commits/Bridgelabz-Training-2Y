import java.util.Scanner;

public class Q2_UniqueCharacters {
    static int findLength(String text) {
        int count = 0;
        while (true) {
            try { text.charAt(count); count++; }
            catch (StringIndexOutOfBoundsException e) { return count; }
        }
    }

    static char[] uniqueCharacters(String text) {
        int n = findLength(text);
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    unique = false;
                    break;
                }
            }
            if (unique) temp[count++] = text.charAt(i);
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) result[i] = temp[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] result = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char ch : result) System.out.print(ch + " ");
    }
}
