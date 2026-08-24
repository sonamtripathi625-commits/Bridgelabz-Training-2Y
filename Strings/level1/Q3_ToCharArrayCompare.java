import java.util.Scanner;

public class Q3_ToCharArrayCompare {
    static char[] getCharacters(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) result[i] = text.charAt(i);
        return result;
    }

    static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        char[] custom = getCharacters(text);
        char[] builtIn = text.toCharArray();
        System.out.println("User-defined characters: " + new String(custom));
        System.out.println("Built-in characters: " + new String(builtIn));
        System.out.println("Both arrays are same: " + compareArrays(custom, builtIn));
    }
}
