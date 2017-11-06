package Assignment_5;

import java.util.Scanner;

/**
 * create an Ubbi Dubbi translator
 *
 * @author tarra7926
 */
public class A5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Scanner for input
        Scanner input = new Scanner(System.in);

        //say "Welcome to the Ubbi Dubbi Translator, to stop type 'STOP' in all capital letters"
        System.out.println("Welcome to the Ubbi Dubbi Translator, to stop type 'STOP' in all capital letters");

        //say "Please enter a word:"
        System.out.print("Please enter a word:");

        //create a string varaiable called 'word' thats = to the next user typed word
        String word = input.nextLine();

        //while the users word is not "STOP" do the following
        while (!word.equals("STOP")) {

            //convert all characters in the 'word' variable to lowercase
            word = word.toLowerCase();

            //create a string builder called 'builder' using the 'word' variable
            StringBuilder builder = new StringBuilder(word);


            //find the first vowel by going through each letter
            for (int i = 0; i < builder.length(); i++) {

                //if variable 'i' does not = 0 and there are two vowels in a row do the following
                if (i != 0 && (builder.charAt(i - 1) == 'a' || builder.charAt(i - 1) == 'e' || builder.charAt(i - 1) == 'i' || builder.charAt(i - 1) == 'o' || builder.charAt(i - 1) == 'u') && (builder.charAt(i) == 'a' || builder.charAt(i) == 'e' || builder.charAt(i) == 'i' || builder.charAt(i) == 'o' || builder.charAt(i) == 'u')) {

                    ///if 'i' is not on the last character in the string add one to 'i' else, stop looking for vowels
                    if (i != (builder.length() - 1)) {
                        i = i + 1;
                    } else {
                        break;

                    }
                }

                //if  variable 'i' is on a vowel inssert "ub" and add two to 'i'
                if (builder.charAt(i) == 'a' || builder.charAt(i) == 'e' || builder.charAt(i) == 'i' || builder.charAt(i) == 'o' || builder.charAt(i) == 'u') {
                    builder.insert(i, "ub");
                    i = i + 2;

                }

                //if variable 'i' is equal to 0 and there are two vowels in a row delete the last "ub" inserted and minus two from variable 'i'
                if (i == 0 && (builder.charAt(i + 1) == 'a' || builder.charAt(i + 1) == 'e' || builder.charAt(i + 1) == 'i' || builder.charAt(i + 1) == 'o' || builder.charAt(i + 1) == 'u') && (builder.charAt(i) == 'a' || builder.charAt(i) == 'e' || builder.charAt(i) == 'i' || builder.charAt(i) == 'o' || builder.charAt(i) == 'u')) {
                    builder.delete(i - 2, i);
                    i = i - 2;

                }
            }

            //create a string variable called 'newWord' from the string builder
            String newWord = builder.toString();

            //say " ---> " with the variable 'word' before the arrow and the variable 'newWord' after
            System.out.println(word + " ---> " + newWord);

            //say "Please enter a word:"
            System.out.print("Please enter another word:");

            //have variable 'word' be equal to the next user typed word
            word = input.nextLine();

        }

        //say "Thanks for using the translator."
        System.out.println("Thanks for using the translator.");

    }
}
