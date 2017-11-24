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
public class A6Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] integers = new int[2];

        System.out.print("Enter 1st integer:");
        integers[0] = input.nextInt();

        System.out.print("Enter 2nd integer:");
        integers[1] = input.nextInt();
        int intHold = integers[1];


        if (integers[0] > integers[1]) {

            integers[1] = integers[0];
            integers[0] = intHold;

        }

        System.out.println("The integers in ascending order are: " + integers[0] + " " + integers[1]);
    }
}
