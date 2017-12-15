package Assignment_7;

import java.util.Scanner;

/**
 * Calculate and output the area of a circle
 *
 * @author tarra7926
 */
public class A7Q1 {

    /**
     * Calculate the area of a circle given its radius
     *
     * @param radius the radius of the circle
     * @return the rounded calculated area
     */
    public double circleArea(double radius) {

        //create a double called answer which is equal to pie times radius squared
        double answer = Math.PI * Math.pow(radius, 2);

        //create a double called answerRounded that rounds to two decimal places
        double answerRounded = Math.ceil(answer * 100) / 100;

        //return the rounded awnser
        return answerRounded;


    }

    /**
     * Gather the radius and output the answer
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called circleArea
        A7Q1 circleArea = new A7Q1();
        //create a scanner for input
        Scanner input = new Scanner(System.in);
        //ouput "Please enter the radius:"
        System.out.println("Please enter the radius: ");

        // get radius from the next user input
        double radius = input.nextDouble();
        //createn double called area which is equal to the asnwer of the method called circle area
        double area = circleArea.circleArea(radius);
        //out put "The area is: " with the variable "area" at the end
        System.out.println("The area is: " + area);
    }
}
