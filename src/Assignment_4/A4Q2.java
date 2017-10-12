package Assignment_4;

import java.util.Scanner;

/**
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


        System.out.print("Please enter the measurement in inches you wish to convert:");

        double inches = input.nextDouble();

        double inchConvert = 2.54 * inches;

        System.out.println(inches + " inches is the same as " + inchConvert + " cm");

    }
}
