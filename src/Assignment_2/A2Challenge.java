package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import becker.robots.Thing;

/**
 *
 * @author tarra7926
 */
public class A2Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create 2 Robots
        Robot alec = new Robot(flavourtown, 1, 3, Direction.SOUTH);
        Robot guyfieri = new Robot(flavourtown, 1, 3, Direction.SOUTH);

        //give guyfieri and alec labels
        alec.setLabel("A");
        guyfieri.setLabel("G");

        //create things
        Thing a = new Thing(flavourtown, 2, 4);
        Thing b = new Thing(flavourtown, 2, 5);
        Thing c = new Thing(flavourtown, 2, 6);
        Thing d = new Thing(flavourtown, 2, 3);
        Thing e = new Thing(flavourtown, 3, 3);
        Thing f = new Thing(flavourtown, 3, 5);
        Thing g = new Thing(flavourtown, 3, 7);
        Thing h = new Thing(flavourtown, 5, 3);
        Thing i = new Thing(flavourtown, 5, 4);
        Thing j = new Thing(flavourtown, 5, 5);
        Thing k = new Thing(flavourtown, 8, 3);
        Thing l = new Thing(flavourtown, 8, 4);
        Thing m = new Thing(flavourtown, 8, 8);
        Thing n = new Thing(flavourtown, 9, 4);
        Thing o = new Thing(flavourtown, 9, 5);
        Thing p = new Thing(flavourtown, 9, 7);

        //create walls
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.WEST);
        new Wall(flavourtown, 3, 1, Direction.WEST);
        new Wall(flavourtown, 4, 1, Direction.WEST);
        new Wall(flavourtown, 5, 1, Direction.WEST);
        new Wall(flavourtown, 6, 1, Direction.WEST);
        new Wall(flavourtown, 7, 1, Direction.WEST);
        new Wall(flavourtown, 8, 1, Direction.WEST);
        new Wall(flavourtown, 9, 1, Direction.WEST);
        new Wall(flavourtown, 10, 1, Direction.WEST);
        new Wall(flavourtown, 1, 2, Direction.EAST);
        new Wall(flavourtown, 2, 2, Direction.EAST);
        new Wall(flavourtown, 3, 2, Direction.EAST);
        new Wall(flavourtown, 4, 2, Direction.EAST);
        new Wall(flavourtown, 5, 2, Direction.EAST);
        new Wall(flavourtown, 6, 2, Direction.EAST);
        new Wall(flavourtown, 7, 2, Direction.EAST);
        new Wall(flavourtown, 8, 2, Direction.EAST);
        new Wall(flavourtown, 9, 2, Direction.EAST);
        new Wall(flavourtown, 10, 2, Direction.EAST);
        new Wall(flavourtown, 1, 3, Direction.EAST);
        new Wall(flavourtown, 2, 4, Direction.NORTH);
        new Wall(flavourtown, 2, 5, Direction.NORTH);
        new Wall(flavourtown, 2, 6, Direction.NORTH);
        new Wall(flavourtown, 2, 7, Direction.NORTH);
        new Wall(flavourtown, 3, 4, Direction.SOUTH);
        new Wall(flavourtown, 3, 5, Direction.SOUTH);
        new Wall(flavourtown, 3, 6, Direction.SOUTH);
        new Wall(flavourtown, 3, 7, Direction.SOUTH);
        new Wall(flavourtown, 2, 7, Direction.EAST);
        new Wall(flavourtown, 3, 7, Direction.EAST);
        new Wall(flavourtown, 5, 4, Direction.SOUTH);
        new Wall(flavourtown, 5, 5, Direction.SOUTH);
        new Wall(flavourtown, 5, 6, Direction.SOUTH);
        new Wall(flavourtown, 5, 4, Direction.NORTH);
        new Wall(flavourtown, 5, 5, Direction.NORTH);
        new Wall(flavourtown, 5, 6, Direction.NORTH);
        new Wall(flavourtown, 5, 6, Direction.EAST);
        new Wall(flavourtown, 4, 3, Direction.EAST);
        new Wall(flavourtown, 6, 3, Direction.EAST);
        new Wall(flavourtown, 7, 3, Direction.EAST);
        new Wall(flavourtown, 8, 4, Direction.NORTH);
        new Wall(flavourtown, 8, 5, Direction.NORTH);
        new Wall(flavourtown, 8, 6, Direction.NORTH);
        new Wall(flavourtown, 8, 7, Direction.NORTH);
        new Wall(flavourtown, 8, 8, Direction.NORTH);
        new Wall(flavourtown, 9, 4, Direction.SOUTH);
        new Wall(flavourtown, 9, 5, Direction.SOUTH);
        new Wall(flavourtown, 9, 6, Direction.SOUTH);
        new Wall(flavourtown, 9, 7, Direction.SOUTH);
        new Wall(flavourtown, 9, 8, Direction.SOUTH);
        new Wall(flavourtown, 8, 8, Direction.EAST);
        new Wall(flavourtown, 9, 8, Direction.EAST);
        new Wall(flavourtown, 10, 3, Direction.EAST);
        new Wall(flavourtown, 10, 3, Direction.SOUTH);




//have alec move than turn right
        while (true) {
            alec.move();
            alec.turnLeft();
            while (true) {


                if (alec.frontIsClear()) {
                    alec.move();
                    break;

                } else {

                    alec.turnLeft();
                    alec.turnLeft();
                    alec.turnLeft();
                    break;
                }

            }
        }
    }
}