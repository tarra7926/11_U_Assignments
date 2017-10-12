package Assignment_4;

import java.util.Scanner;

/**
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

        System.out.print("Enter the speed limit: ");

        double speedLimit = input.nextDouble();

        System.out.print("Enter the recorded speed of the car: ");

        double recSpeed = input.nextDouble();

        if (recSpeed <= speedLimit) {
            System.out.println("Congratulations, you are within the speed limit!");
        }

        if (recSpeed > speedLimit && (recSpeed - speedLimit) <= 20) {
            System.out.println("You are speeding and your fine is $100");
        }
        if (recSpeed > speedLimit && (recSpeed - speedLimit) <= 30 && (recSpeed - speedLimit) >= 21) {
            System.out.println("You are speeding and your fine is $270");
        }
        if (recSpeed > speedLimit && (recSpeed - speedLimit) >= 31) {
            System.out.println("You are speeding and your fine is $500");
        }
    }
}