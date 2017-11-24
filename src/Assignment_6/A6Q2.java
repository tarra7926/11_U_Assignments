/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many people are there:");
        int peopleNum = input.nextInt();

        double[] heights = new double[peopleNum];

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter the height of person #" + (i + 1) + " in feet:");
            heights[i] = input.nextDouble();

        }
        double total = 0;

        for (int i = 0; i < heights.length; i++) {
            total = total + heights[i];

        }
        double average = total / heights.length;

        System.out.print("These are the heights that are above average:");

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > average) {
                System.out.println(heights[i]);

            }



        }
    }
}
