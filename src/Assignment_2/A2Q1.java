package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 * have alec pickup exactly 7 things and get to avenue 11
 *
 * @author tarra7926
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create a Robot
        Robot alec = new Robot(flavourtown, 1, 1, Direction.EAST);

        //create things
        Thing a = new Thing(flavourtown, 1, 2);
        Thing b = new Thing(flavourtown, 1, 3);
        Thing c = new Thing(flavourtown, 1, 4);
        Thing d = new Thing(flavourtown, 1, 5);
        Thing e = new Thing(flavourtown, 1, 6);
        Thing f = new Thing(flavourtown, 1, 7);
        Thing g = new Thing(flavourtown, 1, 8);
        Thing h = new Thing(flavourtown, 1, 9);
        Thing i = new Thing(flavourtown, 1, 10);
        Thing j = new Thing(flavourtown, 1, 11);

        //have alec keep walking forward until he has picked up 7 things
        while (alec.countThingsInBackpack() != 7) {
            alec.move();
            alec.pickThing();
        }

        //have alec move to street 0 avenue 11 if he has 7 things in his backpack
        while (alec.getAvenue() != 12) {
            alec.move();
        }
    }
}