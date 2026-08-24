import java.util.Scanner;
public class Q10_StudentScorecard {
 static int[][] scores(int n){int[][] a=new int[n][3];for(int i=0;i<n;i++)for(int j=0;j<3;j++)a[i][j]=10+(int)(Math.random()*90);return a;}
 static double[][] results(int[][] a){double[][] r=new double[a.length][3];for(int i=0;i<a.length;i++){int t=a[i][0]+a[i][1]+a[i][2];double avg=t/3.0,p=t/3.0;r[i][0]=t;r[i][1]=Math.round(avg*100.0)/100.0;r[i][2]=Math.round(p*100.0)/100.0;}return r;}
 static String grade(double p){if(p>=90)return "A";if(p>=80)return "B";if(p>=70)return "C";if(p>=60)return "D";if(p>=50)return "E";return "F";}
 public static void main(String[] args){Scanner sc=new Scanner(System.in);System.out.print("Enter number of students: ");int n=sc.nextInt();if(n<=0)return;int[][] a=scores(n);double[][] r=results(a);System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");for(int i=0;i<n;i++)System.out.printf("%d\t%d\t%d\t\t%d\t%d\t%.2f\t%.2f%%\t\t%s%n",i+1,a[i][0],a[i][1],a[i][2],(int)r[i][0],r[i][1],r[i][2],grade(r[i][2]));}
}
