package Assignment_7;

import java.util.Scanner;

/**
 * Calculate and output the compound interest
 *
 * @author tarra7926
 */
public class A7Q4 {

    /**
     * calculate and return the compound interest
     *
     * @param yearNum the user inputed year number
     * @param iRate the user inputed rate
     * @param iPrinciple the user inputed initial principle
     * @return
     */
    public double compInterest(int yearNum, double iRate, double iPrinciple) {
        //calculate the unrounded compound interst
        double balance = iPrinciple * Math.pow((1 + iRate), yearNum);
        //create a double called balanceRounded that rounds to two decimal places
        double balanceRounded = Math.ceil(balance * 100) / 100;
        //send back the rounded balance
        return balanceRounded;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a method called compInterest
        A7Q4 compInterest = new A7Q4();
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //say "Please enter the initial principle: "
        System.out.print("Please enter the initial principle: ");
        //create a double variable called iPrinciple which is equal to the next input
        double iPrinciple = input.nextDouble();
        //say "Please enter the interest rate: "
        System.out.print("Please enter the interest rate: ");
        //create a double variable called iRate which is equal to the next input
        double iRate = input.nextDouble();
        //say "Please enter the number of years: "
        System.out.print("Please enter the number of years: ");
        //create a int variable called yearNum which is equal to the next input
        int yearNum = input.nextInt();
        //send the yearNum, iRate, and iPrinciple variables to the method called compInterest
        compInterest.compInterest(yearNum, iRate, iPrinciple);
        double balance = compInterest.compInterest(yearNum, iRate, iPrinciple);
        //say "Please enter the number of years: "
        System.out.print("This is the final balance: $" + balance);

    }
}
