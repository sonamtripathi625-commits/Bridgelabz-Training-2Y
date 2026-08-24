import java.util.Scanner;
public class Q8_StudentVotingRandom {
 static int[] generateAges(int n){int[] a=new int[n];for(int i=0;i<n;i++)a[i]=10+(int)(Math.random()*90);return a;}
 static String[][] check(int[] a){String[][] r=new String[a.length][2];for(int i=0;i<a.length;i++){r[i][0]=String.valueOf(a[i]);r[i][1]=a[i]>=18?"true":"false";}return r;}
 static void display(String[][] r){System.out.println("Age\tCan Vote");for(String[] x:r)System.out.println(x[0]+"\t"+x[1]);}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter number of students: ");int n=sc.nextInt();if(n<=0){System.out.println("Invalid number.");return;}display(check(generateAges(n)));}
}
