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
public class A6Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many students are in the class:");

        int studentNum = input.nextInt();

        double[] marks = new double[studentNum];


        //use a loop to get all the info
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark #" + (i + 1) + ":");
            marks[i] = input.nextDouble();
        }

        double total = 0;
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
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
        double lowMark = marks[0];
        double average = total/(marks.length);
        double highMark = marks[marks.length - 1];

        System.out.println("The lowest mark in the class is: " + lowMark);
        
        System.out.println("The Highest mark in the class is: " + highMark);
        
        System.out.println("The class average is: " + average);

    }
}
