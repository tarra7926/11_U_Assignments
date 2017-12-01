package Assignment_7;

import java.util.Scanner;

/**
 * Output letter equivalent of exam grades
 *
 * @author tarra7926
 */
public class A7Q2 {
    /**
     * Find and output the letter equivalent of the grade
     * @param mark the exam mark
     */

    public void examGrade(double mark) {
        //outputs the letter equivalent of the grade
        if (mark >= 80) {
            System.out.println("Your grade is an A.");
        } else {
            if (mark >= 70) {
                System.out.println("Your grade is an B.");
            } else {
                if (mark >= 60) {
                    System.out.println("Your grade is an C.");
                } else {
                    if (mark >= 50) {
                        System.out.println("Your grade is an D.");
                    } else {
                        if (mark < 50) {
                            System.out.println("Your grade is an F.");
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
        //create a method called examGrade
        A7Q2 examGrade = new A7Q2();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the mark: "
        System.out.print("Please enter the mark: ");
        //create a double variable called mark which is equal to the next input
        double mark = input.nextDouble();
        //send the mark variable to the method called examGrade
        examGrade.examGrade(mark);
    }
}
