package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] marks = new double[10];


        //use a loop to get all the info
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark #" + (i + 1) + ":");
            marks[i] = input.nextDouble();

        }

        double markHold = 0;

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

        System.out.print("The marks in order are: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
    }
}
