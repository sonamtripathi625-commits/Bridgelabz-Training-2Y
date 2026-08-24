import java.util.Scanner;
public class Q3_WordsAndLengths2D {
 static String[] splitWords(String s){s=s.trim();if(s.isEmpty())return new String[0];String[] t=s.split("\\s+");String[] r=new String[t.length];for(int i=0;i<t.length;i++){StringBuilder w=new StringBuilder();for(int j=0;j<t[i].length();j++)w.append(t[i].charAt(j));r[i]=w.toString();}return r;}
 static int findLength(String s){int c=0;while(true){try{s.charAt(c);c++;}catch(StringIndexOutOfBoundsException e){return c;}}}
 static String[][] make(String[] words){String[][] r=new String[words.length][2];for(int i=0;i<words.length;i++){r[i][0]=words[i];r[i][1]=String.valueOf(findLength(words[i]));}return r;}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter a sentence: ");String s=sc.nextLine();String[][] r=make(splitWords(s));System.out.println("Word\tLength");for(String[] x:r)System.out.println(x[0]+"\t"+Integer.parseInt(x[1]));}
}
