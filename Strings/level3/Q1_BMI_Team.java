import java.util.Scanner;

public class Q1_BMI_Team {
    static String bmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        return new String[]{String.format("%.2f", heightM), String.format("%.2f", bmi), bmiStatus(bmi)};
    }

    static String[][] process(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            String[] bmi = calculateBMI(data[i][0], data[i][1]);
            result[i][0] = String.format("%.2f", data[i][1]);
            result[i][1] = String.format("%.2f", data[i][0]);
            result[i][2] = bmi[1];
            result[i][3] = bmi[2];
        }
        return result;
    }

    static void display(String[][] data) {
        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < data.length; i++)
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                data[i][0] = sc.nextDouble();
                System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
                data[i][1] = sc.nextDouble();
                if (data[i][0] <= 0 || data[i][1] <= 0) System.out.println("Enter positive values.");
            } while (data[i][0] <= 0 || data[i][1] <= 0);
        }
        display(process(data));
    }
}
