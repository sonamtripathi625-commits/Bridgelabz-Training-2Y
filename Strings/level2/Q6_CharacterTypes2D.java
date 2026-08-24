import java.util.Scanner;
public class Q6_CharacterTypes2D {
 static String type(char c){if(c>='A'&&c<='Z')c=(char)(c+32);if(c>='a'&&c<='z')return "aeiou".indexOf(c)>=0?"Vowel":"Consonant";return "Not a Letter";}
 static String[][] make(String s){String[][] r=new String[s.length()][2];for(int i=0;i<s.length();i++){r[i][0]=String.valueOf(s.charAt(i));r[i][1]=type(s.charAt(i));}return r;}
 static void display(String[][] r){System.out.println("Character\tType");for(String[] x:r)System.out.println(x[0]+"\t\t"+x[1]);}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter a string: ");display(make(sc.nextLine()));}
}
