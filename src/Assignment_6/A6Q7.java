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
        int[] primeNums = new int[999];



   


        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 2;
        }
        int p = 0;

      for (int i = p; i < nums.length; i = i++) {
                if (primeNums[i] == 0) {
                    p = nums[i];
                    break;
                }
                
            }

            for (int i = p; i < nums.length; i = i + p) {
                primeNums[i] = nums[i];
                
            }
            
            for (int i = p-1; i < nums.length; i = i++) {
                if (primeNums[i] == 0) {
                    p = nums[i];
                    break;
                }
                
            }
        




        for (int i = 0; i < primeNums.length; i++) {
            System.out.print(primeNums[i] + " ");
           
        }
        System.out.println(p);
    }
}
