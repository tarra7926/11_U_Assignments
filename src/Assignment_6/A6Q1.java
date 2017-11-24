package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many students are there:");
        int studentNum = input.nextInt();

        double[] marks = new double[studentNum];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter the mark of student #" + (i + 1) + ":");
            marks[i] = input.nextDouble();

        }
        double total = 0;

        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];

        }
        double average = total / marks.length;

        double roundedAverage = Math.ceil(average * 100) / 100;

        System.out.println("The class average is " + roundedAverage + "%");
    }
}
