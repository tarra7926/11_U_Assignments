package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author tarra7926
 */
public class A2Q4 {
    public static void main(String[] args) {
        City flavourtown = new City();

        //create a Robot
        Robot alec = new Robot(flavourtown, 2, 0, Direction.EAST);

        //creat thing
        new Thing(flavourtown, 2, 8);

        //create walls
        new Wall(flavourtown, 1, 1, Direction.NORTH);
        new Wall(flavourtown, 2, 2, Direction.NORTH);
        new Wall(flavourtown, 2, 3, Direction.NORTH);
        new Wall(flavourtown, 1, 4, Direction.NORTH);
        new Wall(flavourtown, 4, 1, Direction.NORTH);
        new Wall(flavourtown, 4, 4, Direction.NORTH);
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 2, 2, Direction.WEST);
        new Wall(flavourtown, 3, 2, Direction.WEST);
        new Wall(flavourtown, 4, 1, Direction.WEST);
        new Wall(flavourtown, 4, 4, Direction.WEST);
        new Wall(flavourtown, 1, 4, Direction.WEST);
        new Wall(flavourtown, 1, 1, Direction.EAST);
        new Wall(flavourtown, 1, 4, Direction.EAST);
        new Wall(flavourtown, 4, 1, Direction.EAST);
        new Wall(flavourtown, 4, 4, Direction.EAST);
        new Wall(flavourtown, 2, 3, Direction.EAST);
        new Wall(flavourtown, 3, 3, Direction.EAST);
        new Wall(flavourtown, 1, 1, Direction.SOUTH);
        new Wall(flavourtown, 4, 1, Direction.SOUTH);
        new Wall(flavourtown, 1, 4, Direction.SOUTH);
        new Wall(flavourtown, 4, 4, Direction.SOUTH);
        new Wall(flavourtown, 3, 2, Direction.SOUTH);
        new Wall(flavourtown, 3, , Direction.SOUTH);
        



        while (true) {
            
            if (!(alec.frontIsClear())) {
                alec.turnLeft();
                
            } else {

                alec.move();
                alec.turnLeft();
                alec.turnLeft();
                alec.turnLeft();

            }
        }
    }
}

