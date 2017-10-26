package Assignment_5;

import java.util.Scanner;

/**
 *
 * @author tarra7926
 */
public class A5Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                
        
        
        System.out.println("Please enter a word:");
        
        String word = input.nextLine();
        word = word.toLowerCase();
        
        StringBuilder builder = new StringBuilder(word);
        
        
        //find the first vowel by going through each letter
            for(int i = 0; i < builder.length(); i ++){
                
                //look for a vowel at spot 5
                if(builder.charAt(i) == 'a' || builder.charAt(i) == 'e' || builder.charAt(i) == 'i' || builder.charAt(i) == 'o' || builder.charAt(i) == 'u'){
                    builder.insert(i,"ub");
                    i = i +2;
                    
                   
                       
                    if(builder.charAt(i+1) == 'a' || builder.charAt(i+1) == 'e' || builder.charAt(i+1) == 'i' || builder.charAt(i+1) == 'o' || builder.charAt(i+1) == 'u'){
                        i = i + 1;
                    
                    }
                 
                  
                }
                
                 
    }
            String newWord = builder.toString();
            System.out.println("hi " + newWord);
}
}