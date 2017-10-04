package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 * have the robot move and place 10 things in another location using for
 * statements
 *
 * @author tarra7926
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create Robot
        Robot alec = new Robot(flavourtown, 1, 1, Direction.EAST);

        //turn on thing count
        flavourtown.showThingCounts(true);

        //place 10 things at (1,1)
        for (int placeThing = 0; placeThing < 10; placeThing = placeThing + 1) {
            new Thing(flavourtown, 1, 1);
        }

        //have alec pick and move things and stop after 10 times
        for (int pickMove = 0; pickMove < 10; pickMove = pickMove + 1) {
            alec.pickThing();
            alec.move();
            alec.putThing();

            //if alec has picked and moved 9 times, turn left twice, move, and turn left twice again
            if (pickMove != 9) {
                alec.turnLeft();
                alec.turnLeft();
                alec.move();
                alec.turnLeft();
                alec.turnLeft();

            }

        }
    }
}
