package Assignment_2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 * have a alec always move to the origin (0,0)
 *
 * @author tarra7926
 */
public class A2Q3 {

    public static void main(String[] args) {
        City flavourtown = new City();

        //create a Robot
        Robot alec = new Robot(flavourtown, 10, 20, Direction.EAST);

        //while alec is not facing north and is on a street greater than 0, alec turns left
        while (alec.getDirection() != Direction.NORTH && alec.getStreet() > 0) {
            alec.turnLeft();
        }
        //while alec is not facing south and is on a street less than 0, alec turns left
        while (alec.getDirection() != Direction.SOUTH && alec.getStreet() < 0) {
            alec.turnLeft();
        }
        //while alec is on a street other than street 0, alec moves.
        while (alec.getStreet() != 0) {
            alec.move();
        }
        //while alec is not facing west and is on a avenue greater than 0, alec turns left
        while (alec.getDirection() != Direction.WEST && alec.getAvenue() > 0) {
            alec.turnLeft();
        }
        //while alec is not facing west and is on a avenue less than 0, alec turns left
        while (alec.getDirection() != Direction.EAST && alec.getAvenue() < 0) {
            alec.turnLeft();
        }
        //while alec is on an avenue other than avenue 0, alec moves
        while (alec.getAvenue() != 0) {
            alec.move();
        }
    }
}