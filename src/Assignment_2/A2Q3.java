package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author tarra7926
 */
public class A2Q3 {
    public static void main(String[] args) {
        City flavourtown = new City();

        //create a Robot
        Robot alec = new Robot(flavourtown, 2, 0, Direction.EAST);
  
        while (true) {
        if (alec.getAvenue() ==0 && alec.getStreet() ==0) {
                break;
                
            } else {

            while (alec.getDirection() != Direction.NORTH) {
                    alec.turnLeft();

                }
            
}
    }
}
}