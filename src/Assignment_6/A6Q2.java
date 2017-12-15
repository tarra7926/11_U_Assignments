package Assignment_6;

import java.util.Scanner;

/**
 * Gather the heights of people and output the heights that are above average
 *
 * @author tarra7926
 */
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "How many people are there:"
        System.out.print("How many people are there:");
        //create an integer called peopleNum which is equal to the next input
        int peopleNum = input.nextInt();
        //create a double array called heights which is as long as the amount of people
        double[] heights = new double[peopleNum];
        //gather the height of each person
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter the height of person #" + (i + 1) + " in feet:");
            heights[i] = input.nextDouble();

        }
        //create double called total which is equal to 0
        double total = 0;
        //get the total of all the heights
        for (int i = 0; i < heights.length; i++) {
            total = total + heights[i];

        }
        //create double called average which is equal to the average of the heights
        double average = total / heights.length;
        //say "These are the heights that are above average:"
        System.out.print("These are the heights that are above average:");
        //output the heights that are above average
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > average) {
                System.out.println(heights[i]);

            }



        }
    }
}
