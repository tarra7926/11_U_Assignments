package Assignment_4;

import java.util.Scanner;

/**
 * Enter in 4 numbers on separate lines and have the program repeat them
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

        //say "Please enter in 4 numbers on separate lines:"
        System.out.print("Please enter in 4 numbers on separate lines:");

        //create double variable called "num1"
        double num1 = input.nextDouble();

        //create double variable called "num2"
        double num2 = input.nextDouble();

        //create double variable called "num3"
        double num3 = input.nextDouble();

        //create double variable called "num4"
        double num4 = input.nextDouble();

        //say "Please enter in 4 numbers on separate lines:" with variables 
        //"num1", "num2", "num3" after were and variable "num4 after and
        System.out.println("Your numbers were " + num1 + ", " + num2 + ", " + num3 + ", and " + num4);
    }
}
