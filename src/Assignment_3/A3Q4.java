package Assignment_3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/**
 * have the robot move around 4 blocks and end in the same position using for
 * statements
 *
 * @author tarra7926
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City flavourtown = new City();

        //create Robot
        Robot alec = new Robot(flavourtown, 3, 3, Direction.SOUTH);

        //create walls
        new Wall(flavourtown, 1, 1, Direction.NORTH);
        new Wall(flavourtown, 1, 2, Direction.NORTH);
        new Wall(flavourtown, 1, 4, Direction.NORTH);
        new Wall(flavourtown, 1, 5, Direction.NORTH);
        new Wall(flavourtown, 4, 1, Direction.NORTH);
        new Wall(flavourtown, 4, 2, Direction.NORTH);
        new Wall(flavourtown, 4, 4, Direction.NORTH);
        new Wall(flavourtown, 4, 5, Direction.NORTH);
        new Wall(flavourtown, 1, 2, Direction.EAST);
        new Wall(flavourtown, 1, 5, Direction.EAST);
        new Wall(flavourtown, 2, 2, Direction.EAST);
        new Wall(flavourtown, 2, 5, Direction.EAST);
        new Wall(flavourtown, 4, 2, Direction.EAST);
        new Wall(flavourtown, 4, 5, Direction.EAST);
        new Wall(flavourtown, 5, 2, Direction.EAST);
        new Wall(flavourtown, 5, 5, Direction.EAST);
        new Wall(flavourtown, 2, 1, Direction.SOUTH);
        new Wall(flavourtown, 2, 2, Direction.SOUTH);
        new Wall(flavourtown, 5, 1, Direction.SOUTH);
        new Wall(flavourtown, 5, 2, Direction.SOUTH);
        new Wall(flavourtown, 2, 4, Direction.SOUTH);
        new Wall(flavourtown, 2, 5, Direction.SOUTH);
        new Wall(flavourtown, 5, 4, Direction.SOUTH);
        new Wall(flavourtown, 5, 5, Direction.SOUTH);
        new Wall(flavourtown, 1, 1, Direction.WEST);
        new Wall(flavourtown, 2, 1, Direction.WEST);
        new Wall(flavourtown, 4, 1, Direction.WEST);
        new Wall(flavourtown, 5, 1, Direction.WEST);
        new Wall(flavourtown, 1, 4, Direction.WEST);
        new Wall(flavourtown, 2, 4, Direction.WEST);
        new Wall(flavourtown, 4, 4, Direction.WEST);
        new Wall(flavourtown, 5, 4, Direction.WEST);

        //move 1 block 4 times
        for (int move1Block = 0; move1Block < 4; move1Block = move1Block + 1) {

            //follow the side of a block 4 times
            for (int moveBlockSide = 0; moveBlockSide < 4; moveBlockSide = moveBlockSide + 1) {
                alec.move();
                alec.move();
                alec.move();

                //if alec is not on the 3rd side of the block turn left
                if (moveBlockSide != 3) {
                    alec.turnLeft();

                }
            }
        }
    }
}