package Assignment_4;

import java.util.Scanner;

/**
 * have the program calculate the cost of the prom and the amount of tickets
 * needed to fully fund it
 *
 * @author tarra7926
 */
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        //say "How much does the food for prom cost? :"
        System.out.print("How much does the food for prom cost? :");

        Double fCost = input.nextDouble();

        //say "How much does the DJ cost? :"
        System.out.print("How much does the DJ cost? :");

        Double djCost = input.nextDouble();

        //say "How much does it cost to rent the hall? :"
        System.out.print("How much does it cost to rent the hall? :");

        Double rCost = input.nextDouble();

        //say "How much does decorations cost? :"
        System.out.print("How much does decorations cost? :");

        Double dCost = input.nextDouble();

        //say "How much does it cost for staff? :"
        System.out.print("How much does it cost for staff? :");

        Double sCost = input.nextDouble();

        //say "How much How much for miscellaneous costs? :"
        System.out.print("How much for miscellaneous costs? :");

        //create a double a double variable called "mCost"
        double mCost = input.nextDouble();

        //create a double a double variable called "total"
        double total = mCost + sCost + dCost + rCost + djCost + fCost;

        //create a double a double variable called "tickets"
        double tickets = Math.ceil(total / 35);

        //say "The total cost is $ . You will need to sell tickets to break even." 
        //with variable "total" after the $ and the varible "tickets" after sell
        System.out.println("The total cost is $" + total + ". You will need to sell " + tickets + " tickets to break even.");
    }
}
