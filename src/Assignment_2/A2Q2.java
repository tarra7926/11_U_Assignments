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
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create a Robot
        Robot alec = new Robot(flavourtown, 2, 0, Direction.EAST);

        //creat thing
        new Thing(flavourtown, 2, 8);

        //create walls
        new Wall(flavourtown, 2, 0, Direction.SOUTH);
        new Wall(flavourtown, 2, 0, Direction.EAST);
        new Wall(flavourtown, 2, 1, Direction.SOUTH);
        new Wall(flavourtown, 2, 1, Direction.EAST);
        new Wall(flavourtown, 2, 2, Direction.SOUTH);
        new Wall(flavourtown, 2, 3, Direction.SOUTH);
        new Wall(flavourtown, 2, 3, Direction.EAST);
        new Wall(flavourtown, 2, 4, Direction.SOUTH);
        new Wall(flavourtown, 2, 5, Direction.SOUTH);
        new Wall(flavourtown, 2, 6, Direction.SOUTH);
        new Wall(flavourtown, 2, 6, Direction.EAST);
        new Wall(flavourtown, 2, 7, Direction.SOUTH);
        new Wall(flavourtown, 2, 8, Direction.SOUTH);



        while (true) {
            if(alec.canPickThing()) {
                alec.pickThing();
                alec.turnLeft();
                break;
                } else {
            
            while (!(alec.frontIsClear())) {
                alec.turnLeft();


            }

            alec.move();
            alec.turnLeft();
            alec.turnLeft();
            alec.turnLeft();
            
        }
    }
}
}