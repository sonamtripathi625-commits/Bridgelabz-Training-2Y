import java.util.Scanner;

public class Q4_CharacterFrequency {
    static String[][] frequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++)
            freq[text.charAt(i)]++;

        int count = 0;
        for (int i = 0; i < 256; i++) if (freq[i] > 0) count++;

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = frequency(text);
        System.out.println("Character\tFrequency");
        for (String[] row : result)
            System.out.println(row[0] + "\t\t" + row[1]);
    }
}
