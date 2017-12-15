package Assignment_6;

import java.util.Scanner;

/**
 * Gather the marks of a class then determine the highest, lowest, and the
 * average of all the marks
 *
 * @author tarra7926
 */
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "How many students are in the class:"
        System.out.print("How many students are in the class:");
        //create a integer variable called studentNum which is equal to the next input
        int studentNum = input.nextInt();
        //create a double array called marks which is as long as the varible studentNum
        double[] marks = new double[studentNum];


        //fill the marks array using a loop
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark #" + (i + 1) + ":");
            marks[i] = input.nextDouble();
        }
        //create a double variable called total which is equal to 0
        double total = 0;
        //get the total of all the values in the marks array
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }
        //create a double variable called markHold which is equal to 0
        double markHold = 0;
        //sort the values in the marks array in ascending order
        for (int i = 0; i < marks.length; i++) {
            if (i == 0) {
                if (marks[i] > marks[i + 1]) {
                    markHold = marks[i + 1];
                    marks[i + 1] = marks[i];
                    marks[i] = markHold;
                    i = 0;
                }

            } else {
                if (marks[i] < marks[i - 1]) {
                    markHold = marks[i - 1];
                    marks[i - 1] = marks[i];
                    marks[i] = markHold;
                    i = 0;
                }
            }
        }
        //create a double variable called lowMark which is equal to the first value in the marks array
        double lowMark = marks[0];
        //create a double variable called average which is equal to the average of all values in the marks array
        double average = total / (marks.length);
        //create a double variable called highMark which is equal to the last value in the marks array
        double highMark = marks[marks.length - 1];
        //say "The lowest mark in the class is: " + lowMark
        System.out.println("The lowest mark in the class is: " + lowMark);
        //say "The Highest mark in the class is: " + highMark
        System.out.println("The Highest mark in the class is: " + highMark);
        //say "The class average is: " + average
        System.out.println("The class average is: " + average);

    }
}
