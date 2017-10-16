package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Sum of Dice: ");

        int diceSum = input.nextInt();

        while (!(diceSum >= 2 && diceSum <= 12)) {
            System.out.print("You can't roll that number, enter sum again: ");
            diceSum = input.nextInt();
        }

        for (int spotNumber = diceSum + 1; !(spotNumber == 100); spotNumber = spotNumber + diceSum) {
            if (spotNumber > 100) {
                System.out.println("You can only roll the exact number to win the game. Skip turn");
                spotNumber = spotNumber - diceSum;

            }
            System.out.println("You are now on square " + spotNumber);

            if (spotNumber == 9) {
                System.out.println("You landed on a ladder! Moved up to spot 34");
                spotNumber = 34;

            }
            if (spotNumber == 40) {
                System.out.println("You landed on a ladder! Moved up to spot 64");
                spotNumber = 64;

            }
            if (spotNumber == 67) {
                System.out.println("You landed on a ladder! Moved up to spot 86");
                spotNumber = 86;

            }
            if (spotNumber == 54) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 19");
                spotNumber = 19;

            }
            if (spotNumber == 90) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 48");
                spotNumber = 48;

            }
            if (spotNumber == 99) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 77");
                spotNumber = 77;

            }

            System.out.print("Enter Sum of Dice: ");
            diceSum = input.nextInt();

            while (!(diceSum >= 2 && diceSum <= 12)) {
                System.out.print("You can't roll that number, enter sum again: ");
                diceSum = input.nextInt();
            }
        }
        System.out.println("You are now on square 100");
        System.out.println("You Win!");

    }
}
