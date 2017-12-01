package Assignment_6;

import java.util.Scanner;

/**
 * Gathers student marks and calculates the average
 * @author tarra7926
 */
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "How many students are there:"
        System.out.print("How many students are there:");
        //create an integer variable called studentNum which is equal to the next input
        int studentNum = input.nextInt();
        //create a double array called marks which is as long as studentNum
        double[] marks = new double[studentNum];
        //Gather all the marks of the students
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter the mark of student #" + (i + 1) + ":");
            marks[i] = input.nextDouble();

        }
        //create a double variable called total which is = 0
        double total = 0;
        //Add up all the marks
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];

        }
        //create a variable called average which is the marks average
        double average = total / marks.length;
        //round the average
        double roundedAverage = Math.ceil(average * 100) / 100;
        //Say "The class average is %" with the rounded average before the %
        System.out.println("The class average is " + roundedAverage + "%");
    }
}
