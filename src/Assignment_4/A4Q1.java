package Assignment_4;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);
        
        //say type in your name
        System.out.print("Please enter your name:");
        
        String name = input.nextLine();
        
        System.out.print("Hello " + name + ". How are you today?");
        
    }
}
