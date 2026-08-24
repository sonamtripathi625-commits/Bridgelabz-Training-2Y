import java.util.Scanner;
public class Q2_SplitWordsCompare {
 static String[] splitWords(String s){ s=s.trim(); if(s.isEmpty())return new String[0]; int n=1; for(int i=0;i<s.length();i++)if(s.charAt(i)==' ')n++; String[] w=new String[n]; int k=0; StringBuilder x=new StringBuilder(); for(int i=0;i<s.length();i++){char c=s.charAt(i); if(c!=' ')x.append(c); else if(x.length()>0){w[k++]=x.toString();x.setLength(0);}} if(x.length()>0)w[k++]=x.toString(); String[] r=new String[k]; System.arraycopy(w,0,r,0,k); return r; }
 static boolean compare(String[] a,String[] b){if(a.length!=b.length)return false;for(int i=0;i<a.length;i++)if(!a[i].equals(b[i]))return false;return true;}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter a sentence: ");String s=sc.nextLine();String[] a=splitWords(s),b=s.trim().isEmpty()?new String[0]:s.trim().split("\\s+");System.out.println("User-defined split:");for(String x:a)System.out.println(x);System.out.println("Built-in split():");for(String x:b)System.out.println(x);System.out.println("Both results are same: "+compare(a,b));}
}
