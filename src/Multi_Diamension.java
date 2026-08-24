import java.util.Scanner;

public class Multi_Diamension {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter rows and cols: ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            int[][] matrix = new int[rows][cols];
            System.out.println("Enter elements:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // 2D -> 1D Copy
            int[] arr = new int[rows * cols];
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    arr[index++] = matrix[i][j];
                }
            }

            // Print 1D Array
            System.out.println("1D Array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        }
    }
