import java.util.Scanner;
public class Q4_ShortestLongestWord {
 static String[] splitWords(String s){s=s.trim();return s.isEmpty()?new String[0]:s.split("\\s+");}
 static int len(String s){int c=0;while(true){try{s.charAt(c);c++;}catch(StringIndexOutOfBoundsException e){return c;}}}
 static String[][] data(String[] w){String[][] r=new String[w.length][2];for(int i=0;i<w.length;i++){r[i][0]=w[i];r[i][1]=String.valueOf(len(w[i]));}return r;}
 static int[] shortestLongest(String[][] d){if(d.length==0)return new int[]{-1,-1};int s=0,l=0;for(int i=1;i<d.length;i++){if(Integer.parseInt(d[i][1])<Integer.parseInt(d[s][1]))s=i;if(Integer.parseInt(d[i][1])>Integer.parseInt(d[l][1]))l=i;}return new int[]{s,l};}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter a sentence: ");String s=sc.nextLine();String[][] d=data(splitWords(s));int[] r=shortestLongest(d);if(r[0]<0)System.out.println("No words entered.");else{System.out.println("Shortest = "+d[r[0]][0]+" ("+d[r[0]][1]+")");System.out.println("Longest = "+d[r[1]][0]+" ("+d[r[1]][1]+")");}}
}
