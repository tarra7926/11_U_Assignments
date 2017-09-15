package Assignment_1;


import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import java.awt.Color;


/**
 *
 * @author tarra7926
 */
public class A1Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         City flavourtown = new City();
         
         //create Robot
         Robot alec = new Robot(flavourtown, 0, 2, Direction.WEST);
         
         // change alecs's colour to black
        alec.setColor(Color.black);
         
         // create walls
         new Wall(flavourtown, 1, 1, Direction.NORTH);
         new Wall(flavourtown, 1, 2, Direction.NORTH);
         new Wall(flavourtown, 1, 1, Direction.WEST);
         new Wall(flavourtown, 2, 1, Direction.WEST);
         new Wall(flavourtown, 2, 1, Direction.SOUTH);
         new Wall(flavourtown, 2, 2, Direction.SOUTH);
         new Wall(flavourtown, 1, 2, Direction.EAST);
         new Wall(flavourtown, 2, 2, Direction.EAST);
         
         // get alec to move
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
        
         // get alec to move
         alec.move();
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
        
         // get alec to move
         alec.move();
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
         
         // get alec to move
         alec.move();
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
         
         // get alec to move
         alec.move();
         
        
    }
}
