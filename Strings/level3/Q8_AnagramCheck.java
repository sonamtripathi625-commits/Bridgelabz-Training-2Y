import java.util.Scanner;

public class Q8_AnagramCheck {
    static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] freqA = new int[256];
        int[] freqB = new int[256];

        for (int i = 0; i < a.length(); i++) {
            freqA[a.charAt(i)]++;
            freqB[b.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++)
            if (freqA[i] != freqB[i]) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String first = sc.nextLine();
        System.out.print("Enter second text: ");
        String second = sc.nextLine();

        System.out.println("Are the texts anagrams? " + areAnagrams(first, second));
    }
}
