package Assignment_4;

import java.util.Scanner;

/**
 * convert inches to cm
 *
 * @author tarra7926
 */
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        //say "Please enter the measurement in inches you wish to convert:"
        System.out.print("Please enter the measurement in inches you wish to convert:");

        //create double variable called "inches"
        double inches = input.nextDouble();

        //create double variable called "inchConvert"
        double inchConvert = 2.54 * inches;

        //say " inches is the same as cm" with variable "inches" before the word inches and the variable "inchConvert before cm
        System.out.println(inches + " inches is the same as " + inchConvert + " cm");

    }
}
