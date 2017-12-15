package Assignment_7;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A7Q7 {

    /**
     * finds and returns the last digit
     *
     * @param integer
     * @return the first digit of the integer selected by the user
     */
    public int firstDigitCalc(int integer) {
        //while integer is less than 10 or -10 divide by 10
        while (integer > 9 || integer < -9) {
            integer = integer / 10;
        }
        //if integer is less than 0 times it by negative 
        if (integer < 0) {
            integer = integer * -1;
        }
        //create a variable called firstDigit which is equal to the integer variable
        int firstDigit = integer;
        //send back the firstDigit
        return firstDigit;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called firstDigitCalc
        A7Q7 firstDigitCalc = new A7Q7();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the integer: "
        System.out.print("Please enter the integer: ");
        //create a int variable called integer which is equal to the next input
        int integer = input.nextInt();
        //create a int variable called firstDigit which is equal to the firstDigitCalc method with the integer variable
        int firstDigit = firstDigitCalc.firstDigitCalc(integer);
        //say "The first digit is: " + firstDigit
        System.out.println("The first digit is: " + firstDigit);
    }
}
