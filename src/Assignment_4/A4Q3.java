package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter in 4 numbers on separate lines:");
        
        double num1 = input.nextDouble();
        
        double num2 = input.nextDouble();
        
        double num3 = input.nextDouble();
        
        double num4 = input.nextDouble();
        
        System.out.println("Your numbers were " + num1 + ", " + num2 + ", " + num3 + ", and " + num4);
    }
}
