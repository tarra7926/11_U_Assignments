package Assignment_7;

import java.util.Scanner;

/**
 * Get the factors of an integer
 *
 * @author tarra7926
 */
public class A7Q3 {

    /**
     * Find and output the integer
     *
     * @param integer a integer submitted by the user
     */
    public void factors(int integer) {
        //say "These are the factors: "
        System.out.print("These are the factors: ");
        //Find the integer, than output it
        for (int i = 1; i < integer + 1; i++) {
            if (integer % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called factors
        A7Q3 factors = new A7Q3();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the integer: "
        System.out.print("Please enter the integer: ");
        //create a int variable called integer which is equal to the next input
        int integer = input.nextInt();
        //send the integer variable to the method called factors
        factors.factors(integer);


    }
}
