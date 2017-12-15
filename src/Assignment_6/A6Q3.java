package Assignment_6;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A6Q3 {

    /**
     * Gather 2 integers and put them in ascending order
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //create an integer array aclled integers which is 2 long
        int[] integers = new int[2];
        //say "Enter 1st integer:"
        System.out.print("Enter 1st integer:");
        //have the integer array at 0 be equal to the next input
        integers[0] = input.nextInt();
        //say "Enter 2nd integer:"
        System.out.print("Enter 2nd integer:");
        //have the integer array at 1 be equal to the next input
        integers[1] = input.nextInt();
        //create and integer called intHold which is equal to spot 1 in the integer array
        int intHold = integers[1];

        //swap the two spots in the integer array if the integer at spot 0 
        //is greater than the one in spot 1
        if (integers[0] > integers[1]) {

            integers[1] = integers[0];
            integers[0] = intHold;

        }
        //say "The integers in ascending order are: " + integers[0] + " " + integers[1]
        System.out.println("The integers in ascending order are: " + integers[0] + " " + integers[1]);
    }
}
