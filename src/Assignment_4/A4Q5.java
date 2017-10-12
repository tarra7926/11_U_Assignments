package Assignment_4;

import java.util.Scanner;

/**
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

        System.out.print("Please enter your name:");

        String name = input.nextLine();

        System.out.print("What was the first test out of?:");

        double test1Total = input.nextDouble();

        System.out.print("What mark did you get?:");

        double test1Score = input.nextDouble();

        System.out.print("What was the second test out of?:");

        double test2Total = input.nextDouble();

        System.out.print("What mark did you get?:");

        double test2Score = input.nextDouble();

        System.out.print("What was the third test out of?:");

        double test3Total = input.nextDouble();

        System.out.print("What mark did you get?:");

        double test3Score = input.nextDouble();

        System.out.print("What was the fourth test out of?:");

        double test4Total = input.nextDouble();

        System.out.print("What mark did you get?:");

        double test4Score = input.nextDouble();

        System.out.print("What was the fifth test out of?:");

        double test5Total = input.nextDouble();

        System.out.print("What mark did you get?:");

        double test5Score = input.nextDouble();

        System.out.println("Test Scores for " + name);

        double test1Per = test1Score / test1Total * 100;

        double test2Per = test2Score / test2Total * 100;

        double test3Per = test3Score / test3Total * 100;

        double test4Per = test4Score / test4Total * 100;

        double test5Per = test5Score / test5Total * 100;

        System.out.println("Test 1: " + test1Per + "%");

        System.out.println("Test 2: " + test2Per + "%");

        System.out.println("Test 3: " + test3Per + "%");

        System.out.println("Test 4: " + test4Per + "%");

        System.out.println("Test 5: " + test5Per + "%");

        Double testScoreAverage = (test1Per + test2Per + test3Per + test4Per + test5Per)/5;
        
        System.out.println("Average: " + testScoreAverage + "%");
        
    }
}
