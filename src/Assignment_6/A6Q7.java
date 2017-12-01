package Assignment_6;

import java.util.Scanner;

/**
 * 
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
        //create a int variable
        int currentPrime = 0;
        
        while (currentPrime < nums.length/2) {
            for (int i = currentPrime + nums[currentPrime]; i < nums.length; i = i + nums[currentPrime]) {
                nonPrimeNums[i] = nums[i];
            }
            for (int i = currentPrime + 1; i < nums.length; i = i + 1) {
                if (nonPrimeNums[i] == 0) {
                    currentPrime = i;
                    break;
                }
            }
  
        }
        int numOfPrime = 0;
        
        for (int i = 0; i < nums.length; i = i + 1) {
                if (nonPrimeNums[i] == 0) {
                    numOfPrime =  numOfPrime + 1;
       
                }
            }
        
        
        int[] primeNums = new int[numOfPrime];
        
        int primeNumsSpot = -1;
        for (int i = 0; i < nums.length; i = i + 1) {
            if (nonPrimeNums[i] == 0) {
                primeNumsSpot = primeNumsSpot + 1;
                primeNums[primeNumsSpot] = i + 2;
            }
        }
        for (int i = 0; i < primeNums.length; i = i + 1) {
            System.out.print(primeNums[i] + " ");
        }
    }
}