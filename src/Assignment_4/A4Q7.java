package Assignment_4;

import java.util.Scanner;

/**
 * program a game of snakes and ladders
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

        //say "Enter Sum of Dice: "
        System.out.print("Enter Sum of Dice: ");

        //create a integer variable called "diceSum"
        int diceSum = input.nextInt();

        //say "You can't roll that number, enter sum again: " if you roll a number not from 2 to 12
        while (!(diceSum >= 2 && diceSum <= 12)) {
            System.out.print("You can't roll that number, enter sum again: ");
            diceSum = input.nextInt();
        }

        //do the following if spot number is not 100
        for (int spotNumber = diceSum + 1; !(spotNumber == 100); spotNumber = spotNumber + diceSum) {
            //if spotnumber is above 100 say "You can only roll the exact number to win the game. Skip turn"
            if (spotNumber > 100) {
                System.out.println("You can only roll the exact number to win the game. Skip turn");
                spotNumber = spotNumber - diceSum;
            }

            //say "You are now on square " with the variable "spotNumber" after square
            System.out.println("You are now on square " + spotNumber);

            //if you land on spot 9 say "You landed on a ladder! Moved up to spot 34" and have spotNumber = 34
            if (spotNumber == 9) {
                System.out.println("You landed on a ladder! Moved up to spot 34");
                spotNumber = 34;
            }

            //if you land on spot 40 say "You landed on a ladder! Moved up to spot 64" and have spotNumber = 64
            if (spotNumber == 40) {
                System.out.println("You landed on a ladder! Moved up to spot 64");
                spotNumber = 64;
            }

            //if you land on spot 67 say "You landed on a ladder! Moved up to spot 86" and have spotNumber = 86
            if (spotNumber == 67) {
                System.out.println("You landed on a ladder! Moved up to spot 86");
                spotNumber = 86;
            }

            //if you land on spot 54 say "Oh no! You landed on a snake! Moved down to spot 19" and have spotNumber = 19
            if (spotNumber == 54) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 19");
                spotNumber = 19;
            }

            //if you land on spot 90 say "Oh no! You landed on a snake! Moved down to spot 48" and have spotNumber = 48
            if (spotNumber == 90) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 48");
                spotNumber = 48;
            }

            //if you land on spot 99 say "Oh no! You landed on a snake! Moved down to spot 77" and have spotNumber = 77
            if (spotNumber == 99) {
                System.out.println("Oh no! You landed on a snake! Moved down to spot 77");
                spotNumber = 77;
            }
            //say "Enter Sum of Dice: "
            System.out.print("Enter Sum of Dice: ");

            //have variable "diceSum" be = to the next input
            diceSum = input.nextInt();

            //say "You can't roll that number, enter sum again: " if you roll a number not from 2 to 12
            while (!(diceSum >= 2 && diceSum <= 12)) {
                System.out.print("You can't roll that number, enter sum again: ");
                diceSum = input.nextInt();
            }
        }
        //say "You are now on square 100"
        System.out.println("You are now on square 100");
        //say "You Win!"
        System.out.println("You Win!");

    }
}
