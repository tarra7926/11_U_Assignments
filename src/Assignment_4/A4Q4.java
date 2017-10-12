package Assignment_4;

import java.util.Scanner;

/**
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
        
        System.out.print("How much does the food for prom cost? :");
        
        Double fCost = input.nextDouble();
        
        System.out.print("How much does the DJ cost? :");
        
        Double djCost = input.nextDouble();
        
        System.out.print("How much does it cost to rent the hall? :");
        
        Double rCost = input.nextDouble();
        
        System.out.print("How much does decorations cost? :");
        
        Double dCost = input.nextDouble();
        
        System.out.print("How much does it cost for staff? :");
        
        Double sCost = input.nextDouble();
        
        System.out.print("How much for miscellaneous costs? :");
        
        Double mCost = input.nextDouble();
        
        Double total = mCost + sCost + dCost + rCost + djCost + fCost;
        
        Double tickets = Math.ceil(total/35);
        
        System.out.println("The total cost is $" + total + ". You will need to sell " + tickets + " tickets to break even.");
    }
}
    
