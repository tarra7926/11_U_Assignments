package Assignment_7;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A7Q3 {

    public void factors (int integer) {
    
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called examGrade
        A7Q2 factors = new A7Q2();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the mark: "
        System.out.print("Please enter the integer: ");
        //create a double variable called mark which is equal to the next input
        double integer = input.nextDouble();
        //send the mark variable to the method called examGrade
        factors.factors(integer);
    }
}
