package Assignment_6;

import java.util.Scanner;

/**
 * Find all the prime numbers between 2 and 1000
 * @author tarra7926
 */
public class A6Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner called input
        Scanner input = new Scanner(System.in);
        //create and an int array called nums which is 999 long
        int[] nums = new int[999];
        //create and an int array called nonPrimeNums which is 999 long
        int[] nonPrimeNums = new int[999];
        //fill the nums array with the numbers 2 - 1000
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 2;
        }
        //create a int variable called currentPrime  which is equal to 0
        int currentPrime = 0;
        //loop the following if the currentPrime number is less then half the length of the nums array
        while (currentPrime < nums.length/2) {
            //fill the nonPrimeNums arrray with non prime numbers
            for (int i = currentPrime + nums[currentPrime]; i < nums.length; i = i + nums[currentPrime]) {
                nonPrimeNums[i] = nums[i];
            }
            //find the next spot in the nonPrimeNums array that is a prime number and make the currentPrime variable be equal to that spot number
            for (int i = currentPrime + 1; i < nums.length; i = i + 1) {
                if (nonPrimeNums[i] == 0) {
                    currentPrime = i;
                    break;
                }
            }
        }
        //create a int variable called numOdPrime
        int numOfPrime = 0;
        //find how many prime numbers there are int the nonPrimeNums array
        for (int i = 0; i < nums.length; i = i + 1) {
                if (nonPrimeNums[i] == 0) {
                    numOfPrime =  numOfPrime + 1;
       
                }
            }
        
        //create a int array callled prime nums which is as long as the numOfPrime variable
        int[] primeNums = new int[numOfPrime];
        //create a int variable called primeNumsSpot which is equal to -1
        int primeNumsSpot = -1;
        //fill the primeNums array with prime numbers
        for (int i = 0; i < nums.length; i = i + 1) {
            if (nonPrimeNums[i] == 0) {
                primeNumsSpot = primeNumsSpot + 1;
                primeNums[primeNumsSpot] = i + 2;
            }
        }
        System.out.print("These are the prime numbers bewteen 2 and 1000: ");
        //output all prime numbers between 2 and 1000
        for (int i = 0; i < primeNums.length; i = i + 1) {
            System.out.print(primeNums[i] + " ");
        }
    }
}