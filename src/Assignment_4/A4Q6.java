package Assignment_4;

import java.util.Scanner;

/**
 * have the program calculate how much money you owe if you are above the speed
 * limit
 *
 * @author tarra7926
 */
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        //say "Enter the speed limit: "
        System.out.print("Enter the speed limit: ");

        //create a double variable called "speedLimit"
        double speedLimit = input.nextDouble();

        //say "Enter the recorded speed of the car: "
        System.out.print("Enter the recorded speed of the car: ");

        //create a double variable called "recSpeed"
        double recSpeed = input.nextDouble();

        //if the recorded speed is less than or equal to the speed limit say
        //"Congratulations, you are within the speed limit!"
        if (recSpeed <= speedLimit) {
            System.out.println("Congratulations, you are within the speed limit!");
        }

        //if you are between 0 and 20 above the speed limit say "You are speeding and your fine is $100"
        if (recSpeed > speedLimit && (recSpeed - speedLimit) <= 20) {
            System.out.println("You are speeding and your fine is $100");
        }
        //if you are between 20 and 30 above the speed limit say "You are speeding and your fine is $270"
        if (recSpeed > speedLimit && (recSpeed - speedLimit) <= 30 && (recSpeed - speedLimit) >= 21) {
            System.out.println("You are speeding and your fine is $270");
        }
        //if you are above or equal to 31 above the speed limit say "You are speeding and your fine is $500"
        if (recSpeed > speedLimit && (recSpeed - speedLimit) >= 31) {
            System.out.println("You are speeding and your fine is $500");
        }
    }
}