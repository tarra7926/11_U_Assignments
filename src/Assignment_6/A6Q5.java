package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many marks do you wish to enter?:");

        int markNum = input.nextInt();

        double[] marks = new double[markNum];


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

        System.out.println("The marks in order are: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
            System.out.print("The median of the marks is: ");
            if (marks.length % 2 == 0) {
                int evenSpot1 = (marks.length / 2)-1;
                int evenSpot2 = evenSpot1 + 1;
                double median = (marks[evenSpot1] + marks[evenSpot2]) / 2;
                System.out.print(median);
            } else {
                int oddSpot = (marks.length / 2);
                double median = marks[oddSpot];
                System.out.print(median);
            }
        }
    }

