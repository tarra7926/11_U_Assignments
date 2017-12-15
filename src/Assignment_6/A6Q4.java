package Assignment_6;

import java.util.Scanner;

/**
 * Gather 10 marks and sort them in ascending order
 *
 * @author tarra7926
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //create a double array which is 10 spots long
        double[] marks = new double[10];


        //use a loop to gather all the marks
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark #" + (i + 1) + ":");
            marks[i] = input.nextDouble();

        }
        //create an double variable called markHold which is equal to 0
        double markHold = 0;

        //using a loop sort the 10 numbers in ascending order
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
        //output the numbers in ascendig order
        System.out.print("The marks in order are: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }
}
