package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import java.awt.Color;

/**
 * have alec and guyfieri meet in an intersection
 *
 * @author alect
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create 2 Robots
        Robot alec = new Robot(flavourtown, 0, 0, Direction.SOUTH);
        Robot guyfieri = new Robot(flavourtown, 0, 1, Direction.SOUTH);

        // change alecs's and guyfieri's colour to black
        alec.setColor(Color.black);
        guyfieri.setColor(Color.black);

        // create walls
        new Wall(flavourtown, 0, 1, Direction.WEST);
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 1, 1, Direction.SOUTH);

        // get guyfieri turn
        guyfieri.turnLeft();

        // get guyfieri to move
        guyfieri.move();

        // get guyfieri turn
        guyfieri.turnLeft();
        guyfieri.turnLeft();
        guyfieri.turnLeft();

        // get guyfieri to move
        guyfieri.move();
        guyfieri.move();

        // get guyfieri turn
        guyfieri.turnLeft();
        guyfieri.turnLeft();
        guyfieri.turnLeft();

        // get alec to move
        alec.move();
        alec.move();

        // have alec turn
        alec.turnLeft();

        //have guyfieri and alec move
        alec.move();
        guyfieri.move();

    }
}
