import java.util.Scanner;
public class Q7_TrimUsingCharAt {
 static int[] indexes(String s){int a=0,b=s.length()-1;while(a<=b&&s.charAt(a)==' ')a++;while(b>=a&&s.charAt(b)==' ')b--;return new int[]{a,b};}
 static String sub(String s,int a,int b){StringBuilder r=new StringBuilder();for(int i=a;i<=b;i++)r.append(s.charAt(i));return r.toString();}
 static boolean same(String a,String b){if(a.length()!=b.length())return false;for(int i=0;i<a.length();i++)if(a.charAt(i)!=b.charAt(i))return false;return true;}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter text with spaces: ");String s=sc.nextLine();int[] p=indexes(s);String a=p[0]<=p[1]?sub(s,p[0],p[1]):"";String b=s.trim();System.out.println("User-defined trim = ["+a+"]");System.out.println("Built-in trim() = ["+b+"]");System.out.println("Both are same: "+same(a,b));}
}
