package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;
import java.awt.Color;

/**
 * the Robots will pick up things and meet in the middle
 *
 * @author tarra7926
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create 2 Robots
        Robot alec = new Robot(flavourtown, 0, 1, Direction.WEST);
        Robot guyfieri = new Robot(flavourtown, 3, 3, Direction.EAST);

        //create things
        Thing a = new Thing(flavourtown, 0, 0);
        Thing b = new Thing(flavourtown, 1, 0);
        Thing c = new Thing(flavourtown, 1, 1);
        Thing d = new Thing(flavourtown, 1, 2);
        Thing e = new Thing(flavourtown, 2, 2);

        // change alecs's, guyfieri's, and the Thing's colour to black
        alec.setColor(Color.red);
        guyfieri.setColor(Color.red);
        a.setColor(Color.black);
        b.setColor(Color.black);
        c.setColor(Color.black);
        d.setColor(Color.black);
        e.setColor(Color.black);

        //give guyfieri and alec labels
        alec.setLabel("A");
        guyfieri.setLabel("G");

        //create walls
        new Wall(flavourtown, 2, 3, Direction.EAST);
        new Wall(flavourtown, 2, 3, Direction.NORTH);
        new Wall(flavourtown, 2, 3, Direction.WEST);
        new Wall(flavourtown, 3, 3, Direction.EAST);
        new Wall(flavourtown, 3, 3, Direction.SOUTH);

        // get guyfieri turn
        guyfieri.turnLeft();
        guyfieri.turnLeft();

        // get guyfieri to move
        guyfieri.move();

        // get guyfieri turn
        guyfieri.turnLeft();
        guyfieri.turnLeft();
        guyfieri.turnLeft();

        // get guyfieri to move
        guyfieri.move();

        // guyfieri picks up thing
        guyfieri.pickThing();

        // get guyfieri to move
        guyfieri.move();

        // alec picks up thing
        guyfieri.pickThing();

        // get guyfieri turn
        guyfieri.turnLeft();

        // get alec to move
        alec.move();

        // alec picks up thing
        alec.pickThing();

        // get alec turn
        alec.turnLeft();

        // get alec to move
        alec.move();

        // alec picks up thing
        alec.pickThing();

        // get alec turn
        alec.turnLeft();

        // get alec to move
        alec.move();

        // alec picks up thing
        alec.pickThing();

    }
}
