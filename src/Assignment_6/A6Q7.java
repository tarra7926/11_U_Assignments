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
        Scanner input = new Scanner(System.in);
        int[] nums = new int[999];
        int[] nonPrimeNums = new int[999];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 2;
        }
        int p = 0;
        
        while (p < nums.length/2) {
            for (int i = p + nums[p]; i < nums.length; i = i + nums[p]) {
                nonPrimeNums[i] = nums[i];
            }
            for (int i = p + 1; i < nums.length; i = i + 1) {
                if (nonPrimeNums[i] == 0) {
                    p = i;
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