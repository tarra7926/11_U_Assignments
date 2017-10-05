package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 * have the robot plant a 4 by 5 area of things using for statements
 * @author tarra7926
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create Robot
        Robot alec = new Robot(flavourtown, 1, 1, Direction.EAST, 20);

        //turn on thing count
        flavourtown.showThingCounts(true);

        //have alec place 4 rows of things
        for (int putRowThing = 0; putRowThing < 4; putRowThing = putRowThing + 1) {

            //have alec put a thing down and move 5 times
            for (int putThing = 0; putThing < 5; putThing = putThing + 1) {
                alec.putThing();
                alec.move();
            }

            //if alec is facing east turn right and move until he is facing west
            if (alec.getDirection() == Direction.EAST) {
                while (alec.getDirection() != Direction.WEST) {
                    alec.turnLeft();
                    alec.turnLeft();
                    alec.turnLeft();
                    alec.move();
                }
            } else {

                //otherwise alec will turn left and move until he is facing east
                while (alec.getDirection() != Direction.EAST) {
                    alec.turnLeft();
                    alec.move();

                }
            }
        }
    }
}
