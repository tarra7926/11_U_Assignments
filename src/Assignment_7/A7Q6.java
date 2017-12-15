package Assignment_7;

import java.util.Scanner;

/**
 * Find the last digit of an integer
 *
 * @author tarra7926
 */
public class A7Q6 {

    /**
     * Calculate and send the last digit
     *
     * @param integer
     * @return the last digit of the integer selected by the user
     */
    public int lastDigitCalc(int integer) {
        //check if the integer variable is positive or negative, find and return the last digit
        if (integer > 0) {
            int lastDigit = integer % 10;
            return lastDigit;
        } else {
            int lastDigit = (integer % 10) * -1;
            return lastDigit;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called lastDigitCalc
        A7Q6 lastDigitCalc = new A7Q6();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the integer: "
        System.out.print("Please enter the integer: ");
        //create a int variable called integer which is equal to the next input
        int integer = input.nextInt();
        //create a int variable called lastDigit which is equal to the lastDigitCalc method with the integer variable
        int lastDigit = lastDigitCalc.lastDigitCalc(integer);
        //say "The last digit is: " + lastDigit
        System.out.println("The last digit is: " + lastDigit);
    }
}