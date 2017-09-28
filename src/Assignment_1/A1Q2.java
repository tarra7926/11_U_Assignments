package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import becker.robots.Thing;
import java.awt.Color;

/**
 * have alec walk out of bed, pick up newspaper, and return to bed
 *
 * @author tarra7926
 */
public class A1Q2 {

    public static void main(String[] args) {
        City flavourtown = new City();

        //create a robot and a thing
        Robot alec = new Robot(flavourtown, 1, 2, Direction.SOUTH);
        Thing a = new Thing(flavourtown, 2, 2);

        // change alecs's and thing's colour to black
        alec.setColor(Color.black);
        a.setColor(Color.black);

        // create walls
        new Wall(flavourtown, 1, 1, Direction.NORTH);
        new Wall(flavourtown, 1, 2, Direction.NORTH);
        new Wall(flavourtown, 2, 2, Direction.NORTH);
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.SOUTH);
        new Wall(flavourtown, 1, 2, Direction.EAST);

        // have alec turn
        alec.turnLeft();
        alec.turnLeft();
        alec.turnLeft();

        // get alec to move
        alec.move();

        // have alec turn
        alec.turnLeft();

        // get alec to move
        alec.move();

        // have alec turn
        alec.turnLeft();

        // get alec to move
        alec.move();

        // alec picks up thing
        alec.pickThing();

        // have alec turn
        alec.turnLeft();
        alec.turnLeft();

        // get alec to move
        alec.move();

        // have alec turn
        alec.turnLeft();
        alec.turnLeft();
        alec.turnLeft();

        // get alec to move
        alec.move();

        // have alec turn
        alec.turnLeft();
        alec.turnLeft();
        alec.turnLeft();

        // get alec to move
        alec.move();

        // have alec turn
        alec.turnLeft();
        alec.turnLeft();
        alec.turnLeft();

    }
}
