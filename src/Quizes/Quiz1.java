package Quizes;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 * The robot will clear out the things in the mine one at a time
 *
 * @author tarra7926
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create Robot
        Robot alec = new Robot(flavourtown, 1, 1, Direction.EAST);

        //create walls
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 1, 5, Direction.EAST);
        new Wall(flavourtown, 1, 3, Direction.NORTH);
        new Wall(flavourtown, 1, 3, Direction.SOUTH);
        new Wall(flavourtown, 1, 4, Direction.NORTH);
        new Wall(flavourtown, 1, 4, Direction.SOUTH);
        new Wall(flavourtown, 1, 5, Direction.NORTH);
        new Wall(flavourtown, 1, 5, Direction.SOUTH);

        //create things
        new Thing(flavourtown, 1, 3);
        new Thing(flavourtown, 1, 4);
        new Thing(flavourtown, 1, 5);

        //while the robots front is clear it will do the following
        while (alec.frontIsClear()) {

            //alec moves forward
            alec.move();

            //if alec can pick up a thing he will do the following
            if (alec.canPickThing()) {

                //alec picks up a thing and turns around
                alec.pickThing();
                alec.turnLeft();
                alec.turnLeft();

                //while alec's front is clear he will move toward the start of the mine
                while (alec.frontIsClear()) {
                    alec.move();
                }

                //alec turns around and places the thing at the start of the mine
                alec.turnLeft();
                alec.turnLeft();
                alec.putThing();
            }
        }
        //alec turns around
        alec.turnLeft();
        alec.turnLeft();

        //while alec's front is clear he will move toward the start of the mine
        while (alec.frontIsClear()) {
            alec.move();
        }

        //alec turns around
        alec.turnLeft();
        alec.turnLeft();
    }
}