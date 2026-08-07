import java.util.*;
import java .util.Scanner;
public class triangle_Parameter {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int[] arr=new int[n];
        System.out.println(n);
         for(int i=0;i<n;i++) {
             arr[i] = sc.nextInt();
         }
              Arrays.sort(arr);
             for (int i = n - 1; i >= 2; i--) {
                 if (arr[i - 2] + arr[i - 1] > arr[i]) {
                     System.out.println("largest parameter "+(arr[i - 2] + arr[i - 1] + arr[i]));
                 }
             }

        System.out.println(0);
    }
}

