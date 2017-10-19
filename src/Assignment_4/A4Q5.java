package Assignment_4;

import java.util.Scanner;

/**
 * have the program ask for 5 test marks and their totals and calculate the
 * averages of the tests and the total average
 *
 * @author tarra7926
 */
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        //say "Please enter your name:"
        System.out.print("Please enter your name:");

        //create a string variable called "name"
        String name = input.nextLine();

        //say "What was the first test out of?:"
        System.out.print("What was the first test out of?:");

        //create a double variable called "test1Total"
        double test1Total = input.nextDouble();

        //say "What mark did you get?:"
        System.out.print("What mark did you get?:");

        //create a double variable called "test1Score"
        double test1Score = input.nextDouble();

        //say "What was the second test out of?:"
        System.out.print("What was the second test out of?:");

        //create a double variable called "test2Total"
        double test2Total = input.nextDouble();

        //say "What mark did you get?:"
        System.out.print("What mark did you get?:");

        //create a double variable called "test2Score"
        double test2Score = input.nextDouble();

        //say "What was the third test out of?:"
        System.out.print("What was the third test out of?:");

        //create a double variable called "test3Total"        
        double test3Total = input.nextDouble();

        //say "What mark did you get?:"
        System.out.print("What mark did you get?:");

        //create a double variable called "test3Score"
        double test3Score = input.nextDouble();

        //say "What was the fourth test out of?:"
        System.out.print("What was the fourth test out of?:");

        //create a double variable called "test4Total"
        double test4Total = input.nextDouble();

        //say "What mark did you get?:"
        System.out.print("What mark did you get?:");

        //create a double variable called "test4Score"
        double test4Score = input.nextDouble();

        //say "What was the fifth test out of?:"
        System.out.print("What was the fifth test out of?:");

        //create a double variable called "test5Total"
        double test5Total = input.nextDouble();

        //say "What mark did you get?:"
        System.out.print("What mark did you get?:");

        //create a double variable called "test5Score"
        double test5Score = input.nextDouble();

        //say "Test Scores for " with the variable "name" after for
        System.out.println("Test Scores for " + name);

        //create a double variable called "test1Per"
        double test1Per = test1Score / test1Total * 100;

        //create a double variable called "test2Per"
        double test2Per = test2Score / test2Total * 100;

        //create a double variable called "test3Per"
        double test3Per = test3Score / test3Total * 100;

        //create a double variable called "test4Per"
        double test4Per = test4Score / test4Total * 100;

        //create a double variable called "test5Per"
        double test5Per = test5Score / test5Total * 100;

        //say "Test 1: %" with variable "test1Per" after the :
        System.out.println("Test 1: " + test1Per + "%");

        //say "Test 2: %" with variable "test2Per" after the :
        System.out.println("Test 2: " + test2Per + "%");

        //say "Test 3: %" with variable "test3Per" after the :
        System.out.println("Test 3: " + test3Per + "%");

        //say "Test 4: %" with variable "test4Per" after the :
        System.out.println("Test 4: " + test4Per + "%");

        //say "Test 5: %" with variable "test5Per" after the :
        System.out.println("Test 5: " + test5Per + "%");

        //create double variable "testScoreAverage"
        double testScoreAverage = (test1Per + test2Per + test3Per + test4Per + test5Per) / 5;

        //say "Average: %" with the variable "testScoreAverage" before the %
        System.out.println("Average: " + testScoreAverage + "%");

    }
}
