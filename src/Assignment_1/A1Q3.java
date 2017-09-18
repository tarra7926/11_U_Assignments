package Assignment_1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;
import becker.robots.Thing;
import java.awt.Color;

/**
 *have Alec pick up flag, walk to top of mountain, plant flag, walk to bottom of mountain
 * @author tarra7926
 */
    
    public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String[] args) {
         City flavourtown = new City();
         
         //create Robot and thing
         Robot alec = new Robot(flavourtown, 3, 0, Direction.EAST);
         new Thing(flavourtown, 3, 1);
         
         // change alecs's colour to black
         alec.setColor(Color.black);
         
         // create walls
         new Wall(flavourtown, 1, 3, Direction.NORTH);
         new Wall(flavourtown, 1, 3, Direction.WEST);
         new Wall(flavourtown, 2, 3, Direction.WEST);
         new Wall(flavourtown, 3, 2, Direction.NORTH);
         new Wall(flavourtown, 3, 2, Direction.WEST);
         new Wall(flavourtown, 1, 3, Direction.EAST);
         new Wall(flavourtown, 2, 4, Direction.NORTH);
         new Wall(flavourtown, 2, 4, Direction.EAST);
         new Wall(flavourtown, 3, 4, Direction.EAST);
         
         // get alec to move
         alec.move();
         
         // alec picks up thing
         alec.pickThing();
         
         // have alec turn
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
         
         // get alec to move
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
         alec.turnLeft();
         alec.turnLeft();
         
         // get alec to move
         alec.move();
         
         //have alec drop thing
         alec.putThing();
         
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
         
         // get alec to move
         alec.move();
         
         // have alec turn
         alec.turnLeft();
         alec.turnLeft();
         alec.turnLeft();
         
         // get alec to move
         alec.move();
         alec.move();
         
         // have alec turn
         alec.turnLeft();
    }    
}
    
