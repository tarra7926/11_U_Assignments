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
        StringBuilder builder = new StringBuilder(word);
        
        
        //find the first vowel by going through each letter
            for(int i = 0; i < word.length(); i ++){
                
                //look for a vowel at spot 5
                if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                    builder.insert(i,"ub");
                       word = word + 2;
                    
                    if(word.charAt(i+1) == 'a' || word.charAt(i+1) == 'e' || word.charAt(i+1) == 'i' || word.charAt(i+1) == 'o' || word.charAt(i+1) == 'u'){
                        i = i + 1;
                    }
                   
                  
                }
                 
    }
            String newWord = builder.toString();
            System.out.println("hi " + newWord);
}
}