package Assignment_7;

import java.util.Scanner;

/**
 * Generate a random number of asterisks between 1 and 5 on the amount of lines
 * the user wants
 *
 * @author tarra7926
 */
public class A7Q5 {

    /**
     * Generate the random number and output the asterisks
     *
     * @param lineNum The user inputted number of lines
     */
    public void astGen(int lineNum) {
        //generate the random number of asterisks on each line
        for (int i = 0; i < lineNum; i++) {
            int randNum = (int) (Math.random() * (5 - 1 + 1)) + 1;
            if (randNum == 5) {
                System.out.println("*****");
            } else {
                if (randNum == 4) {
                    System.out.println("****");
                } else {
                    if (randNum == 3) {
                        System.out.println("***");
                    } else {
                        if (randNum == 2) {
                            System.out.println("**");
                        } else {
                            if (randNum == 1) {
                                System.out.println("*");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called astGen
        A7Q5 astGen = new A7Q5();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the amount of lines: "
        System.out.print("Please enter the amount of lines: ");
        //create a int variable called lineNum which is equal to the next input
        int lineNum = input.nextInt();
        //send the lineNum variable to the method called astGen
        astGen.astGen(lineNum);
    }
}
