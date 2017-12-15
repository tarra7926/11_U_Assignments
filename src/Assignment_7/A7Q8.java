package Assignment_7;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A7Q8 {

    /**
     * find the digits and figure out if they are even or odd
     *
     * @param integer a positive integer selected by the user
     * @return the allOdd variable
     */
    public boolean allDigitsOdd(int integer) {
        //create a boolean variable called allOdd which is equal to false
        boolean allOdd = false;
        //calculate all digits and check each one to see if they're even or odd
        for (int i = 0; integer > 0; i++) {
            int digit = integer % 10;
            if (digit % 2 == 0) {
                allOdd = false;
                break;
            } else {
                allOdd = true;
            }
            integer = integer / 10;
        }
        //return the all odd variable
        return allOdd;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called allDigitsOdd
        A7Q8 allDigitsOdd = new A7Q8();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the integer: "
        System.out.print("Please enter the integer: ");
        //create a int variable called integer which is equal to the next input
        int integer = input.nextInt();
        //if integer is negative make it positive
        if (integer < 0) {
            integer = integer * -1;
        }
        //create a boolean variable called trueOrFalse which is equal to the allDigitsOdd method with the integer variable
        boolean trueOrFalse = allDigitsOdd.allDigitsOdd(integer);
        //if trueOrFalse is equal to true say "All digits are odd" if not say "All digits aren't odd"
        if (trueOrFalse == true) {
            System.out.println("All digits are odd");
        } else {
            System.out.println("All digits aren't odd");
        }
    }
}