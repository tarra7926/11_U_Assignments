package Assignment_6;

import java.util.Scanner;

/**
 * Gather 10 marks, sort them in ascending order, and get the median
 * @author tarra7926
 */
public class A6Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "How many marks do you wish to enter?:"
        System.out.print("How many marks do you wish to enter?:");
        //create a variable called markNum which is equal to the next input
        int markNum = input.nextInt();
        //create a double array called marks and which is as long as the varible markNum
        double[] marks = new double[markNum];


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
        //using a loop ouput the numbers in order
        System.out.println("The marks in order are: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        //calulate and output the median of the marks
        System.out.print("The median of the marks is: ");
        if (marks.length % 2 == 0) {
            int evenSpot1 = (marks.length / 2) - 1;
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
