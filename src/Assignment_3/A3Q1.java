package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import java.awt.Color;

/**
 * have the robot go around the square 2 times using for statements
 *
 * @author tarra7926
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create Robot
        Robot alec = new Robot(flavourtown, 0, 2, Direction.WEST);

        // change alecs's colour to black
        alec.setColor(Color.black);

        // create walls
        new Wall(flavourtown, 1, 1, Direction.NORTH);
        new Wall(flavourtown, 1, 2, Direction.NORTH);
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.SOUTH);
        new Wall(flavourtown, 2, 2, Direction.SOUTH);
        new Wall(flavourtown, 1, 2, Direction.EAST);
        new Wall(flavourtown, 2, 2, Direction.EAST);

        //have alec count his moves and stop moving after 23 times
        for (int moveCounter = 0; moveCounter < 24; moveCounter = moveCounter + 1) {

            //while alec's front is not clear turn right
            while (!(alec.frontIsClear())) {
                alec.turnLeft();
                alec.turnLeft();
                alec.turnLeft();
            }

            //have alec move, than turn left if he has not moved 23 times
            alec.move();
            if (moveCounter != 23) {
                alec.turnLeft();

            }
        }
    }
}