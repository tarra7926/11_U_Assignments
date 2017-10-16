package Assignment_4;

import java.util.Scanner;

/**
 * have the program greet the user by inputed name
 * @author tarra7926
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);
        
        //say "Please enter your name:"
        System.out.print("Please enter your name:");
        
        //create variable name
        String name = input.nextLine();
        
        //say "Hello .How are you today?" with variable name after hello
        System.out.print("Hello " + name + ". How are you today?");
        
    }
}
