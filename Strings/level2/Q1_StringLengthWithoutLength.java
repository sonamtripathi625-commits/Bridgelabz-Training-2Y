import java.util.Scanner;
public class Q1_StringLengthWithoutLength {
 static int findLength(String s){ int count=0; while(true){ try{s.charAt(count);count++;}catch(StringIndexOutOfBoundsException e){return count;} } }
 public static void main(String[] args){ Scanner sc=new Scanner(System.in); System.out.print("Enter a string: "); String s=sc.next(); int a=findLength(s),b=s.length(); System.out.println("Length without length() = "+a); System.out.println("Length using length() = "+b); System.out.println("Both are same: "+(a==b)); }
}
