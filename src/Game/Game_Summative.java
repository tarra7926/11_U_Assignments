package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * A game where you reflect a ball of a paddle and walls in an attempt to destroy all the blocks
 * @author tarra7926
 */
public class Game_Summative extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Block Breaker";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    //the integer variable for the paddle's width
    int paddleWidth = 100;
    //the integers variable for the paddle's height
    int paddleHeight = 20;
    //the integer variable for the space between the borders
    int borderSpace = 30;
    //the left half of the player's paddle
    Rectangle playerPart1 = new Rectangle((WIDTH / 2) - (paddleWidth / 2), HEIGHT - 50, paddleWidth / 2, paddleHeight / 2);
    //the right half of the player's paddle 
    Rectangle playerPart2 = new Rectangle(playerPart1.x + playerPart1.width, HEIGHT - 50, playerPart1.width, playerPart1.height);
    //the arrays for the gray, yellow, and red blocks
    Rectangle[] grayBlocks = new Rectangle[26];
    Rectangle[] yellowBlocks = new Rectangle[18];
    Rectangle[] redBlocks = new Rectangle[10];
    //the rectangles that make the borders
    Rectangle gBorderLeft = new Rectangle(borderSpace, borderSpace, 7, HEIGHT);
    Rectangle gBorderRight = new Rectangle(WIDTH - borderSpace - 1, borderSpace, 7, HEIGHT);
    Rectangle gBorderTop = new Rectangle(borderSpace, borderSpace, WIDTH - borderSpace * 2 - 1, 7);
    //the arrays for the gray, yellow, and red blocks life
    int[] grayBlockLife = new int[grayBlocks.length];
    int[] yellowBlockLife = new int[yellowBlocks.length];
    int[] redBlockLife = new int[redBlocks.length];
    //the integer variable for the blocks height
    int blockHeight = 25;
    //the integer variable for the block's width
    int blockWidth = 50;
    //the integer variable for the ball's height
    int ballHeight = 25;
    //the integer variable for the ball's width
    int ballWidth = 25;
    //the integer variable for the ball's starting x value
    int startBallX = (WIDTH / 2) - (ballWidth / 2);
    //the integer variable for the ball's starting y value
    int startBallY = playerPart1.y - 100;
    //the integer variable for the space between the blocks
    int blockSpace = 25;
    //the rectangle that makes the ball
    Rectangle ball = new Rectangle(startBallX, startBallY, ballWidth, ballHeight);
    //the integer variable for the paddle's speed
    int paddleSpeed = 12;
    //the integer variable for the ball's speed
    int ballSpeed = 6;
    //the integer variable for the ball's x direction
    int ballXDirection = 0;
    //the integer variable for the ball's Y direction
    int ballYDirection = 0;
    //the integer variable for the lives of the player
    int lives = 3;
    //the boolean variable for when the player is moving left
    boolean playerLeft = false;
    //the boolean variable for when the player is moving right
    boolean playerRight = false;
    //the boolean variable for when the player is pressing the enter key
    boolean enter = false;
    //the boolean variable for when all yellow blocks have full life
    boolean yellowBlockFullLife = true;
    //the boolean variable for when all red blocks have full life
    boolean redBlockFullLife = true;
    //the boolean variable for when all gray blocks have been destroyed
    boolean allGrayGone = false;
    //the boolean variable for when all yellow blocks have been destroyed
    boolean allYellowGone = false;
    //the boolean variable for when all red blocks have been destroyed
    boolean allRedGone = false;
    //the integer variable for the amount of gray blocks that have dissapeared
    int grayCounter = 0;
    //the integer variable for the amount of yellow blocks that have dissapeared
    int yellowCounter = 0;
    //the integer variable for the amount of red blocks that have dissapeared
    int redCounter = 0;
    //a bigger sized Swis721 BlkOul BT font
    Font biggerFont = new Font("Swis721 BlkOul BT", Font.BOLD, 60);
    //a normal sized Swis721 BlkOul BT font
    Font font = new Font("Swis721 BlkOul BT", Font.BOLD, 42);
    //a smaller sized Swis721 BlkOul BT font
    Font smallerFont = new Font("Swis721 BlkOul BT", Font.BOLD, 22);
    //a new red color
    Color candyRed = new Color(217, 0, 101);
    //a new neon blue color
    Color skyBlue = new Color(72, 231, 236);
    // GAME VARIABLES END HERE   

    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Game_Summative() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();

        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //set the drawing color to black
        g.setColor(Color.BLACK);
        //make the background black
        g.fillRect(0, 0, WIDTH, HEIGHT);
        //draw all gray blocks in gray
        for (int i = 0; i < grayBlocks.length; i++) {
            g.setColor(Color.GRAY);
            if (grayBlocks[i] != null) {
                g.fillRect(grayBlocks[i].x, grayBlocks[i].y, grayBlocks[i].width, grayBlocks[i].height);
            }
        }
        //draw all yellow blocks in yellow or gray depending on how much health they have
        for (int i = 0; i < yellowBlocks.length; i++) {
            g.setColor(Color.YELLOW);
            if (yellowBlockLife[i] == 1) {
                g.setColor(Color.GRAY);
            }

            if (yellowBlocks[i] != null) {
                g.fillRect(yellowBlocks[i].x, yellowBlocks[i].y, yellowBlocks[i].width, yellowBlocks[i].height);
            }
        }
        //draw all red blocks in red, yellow, or gray depending on how much health they have
        for (int i = 0; i < redBlocks.length; i++) {
            g.setColor(candyRed);
            if (redBlockLife[i] == 2) {
                g.setColor(Color.YELLOW);
            }
            if (redBlockLife[i] == 1) {
                g.setColor(Color.GRAY);
            }
            if (redBlocks[i] != null) {
                g.fillRect(redBlocks[i].x, redBlocks[i].y, redBlocks[i].width, redBlocks[i].height);
            }
        }
        //if the ball is not moving in the Y direction write "Block" and"Breaker" in white, bigger font and "Press ENTER to Start" in white normal font
        if (ballYDirection == 0) {
            g.setColor(Color.WHITE);
            g.setFont(biggerFont);
            g.drawString("Block", (WIDTH / 2) - 95, 190);
            g.drawString("Breaker", (WIDTH / 2) - 134, 250);
            g.setFont(font);
            g.drawString("Press ENTER to Start", (WIDTH / 2) - 250, HEIGHT / 2 + 100);
            //if the player is pressing down the enter key change the ball's Y direction to 1
            if (enter) {
                ballYDirection = 1;
            }
        }
        //set the font to the smaller font
        g.setFont(smallerFont);
        //set the draw color to skyBlue
        g.setColor(skyBlue);
        //write lives left int the top right corner of the screen
        g.drawString("Lives Left: " + lives, WIDTH - 180, 23);
        //draw the player
        g.fillRect(playerPart1.x, playerPart1.y, playerPart1.width, playerPart1.height);
        g.fillRect(playerPart2.x, playerPart2.y, playerPart2.width, playerPart2.height);
        //draw the ball
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        //draw the borders
        g.fillRect(gBorderLeft.x, gBorderLeft.y, gBorderLeft.width, gBorderLeft.height);
        g.fillRect(gBorderRight.x, gBorderRight.y, gBorderRight.width, gBorderRight.height);
        g.fillRect(gBorderTop.x, gBorderTop.y, gBorderTop.width, gBorderTop.height);
        //set the font to the bigger font
        g.setFont(biggerFont);
        //if the player loses all their lives, display a screen with words "you lose" in white, bigger font
        if (lives <= 0) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("You Lose", (WIDTH / 2) - 150, HEIGHT/2);
        }
        //if the player destroys all the blocks, display a screen with the words "you win" in white bigger font
        if (allGrayGone && allYellowGone && allRedGone) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("You Win!", (WIDTH / 2) - 150, HEIGHT/2);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        //Any of your pre setup before the loop starts should go here
        //define all of the gray blocks
        grayBlocks[0] = new Rectangle((WIDTH / 2) - (blockWidth / 2), (HEIGHT / 2) - (blockHeight / 2) + 25, blockWidth, blockHeight);
        grayBlocks[1] = new Rectangle(grayBlocks[0].x - blockWidth - blockSpace, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[2] = new Rectangle(grayBlocks[0].x + blockWidth + blockSpace, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[3] = new Rectangle(grayBlocks[0].x - (blockWidth * 2) - (blockSpace * 2), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[4] = new Rectangle(grayBlocks[0].x - (blockWidth * 3) - (blockSpace * 3), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[5] = new Rectangle(grayBlocks[0].x - (blockWidth * 4) - (blockSpace * 4), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[6] = new Rectangle(grayBlocks[0].x + blockWidth * 2 + blockSpace * 2, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[7] = new Rectangle(grayBlocks[0].x + blockWidth * 3 + blockSpace * 3, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[8] = new Rectangle(grayBlocks[0].x + blockWidth * 4 + blockSpace * 4, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[9] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace * 2, blockWidth, blockHeight);
        grayBlocks[10] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace * 4, blockWidth, blockHeight);
        grayBlocks[11] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace * 6, blockWidth, blockHeight);
        grayBlocks[12] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace * 8, blockWidth, blockHeight);
        grayBlocks[13] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace * 10, blockWidth, blockHeight);
        grayBlocks[14] = new Rectangle(grayBlocks[7].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[15] = new Rectangle(grayBlocks[6].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[16] = new Rectangle(grayBlocks[2].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[17] = new Rectangle(grayBlocks[5].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[18] = new Rectangle(grayBlocks[4].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[19] = new Rectangle(grayBlocks[3].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[20] = new Rectangle(grayBlocks[1].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[21] = new Rectangle(grayBlocks[0].x, grayBlocks[13].y, blockWidth, blockHeight);
        grayBlocks[22] = new Rectangle(grayBlocks[5].x, grayBlocks[12].y, blockWidth, blockHeight);
        grayBlocks[23] = new Rectangle(grayBlocks[5].x, grayBlocks[11].y, blockWidth, blockHeight);
        grayBlocks[24] = new Rectangle(grayBlocks[5].x, grayBlocks[10].y, blockWidth, blockHeight);
        grayBlocks[25] = new Rectangle(grayBlocks[5].x, grayBlocks[9].y, blockWidth, blockHeight);
        //define all of the yellow blocks
        yellowBlocks[0] = new Rectangle(grayBlocks[4].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[1] = new Rectangle(grayBlocks[4].x, grayBlocks[10].y, blockWidth, blockHeight);
        yellowBlocks[2] = new Rectangle(grayBlocks[4].x, grayBlocks[11].y, blockWidth, blockHeight);
        yellowBlocks[3] = new Rectangle(grayBlocks[4].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[4] = new Rectangle(grayBlocks[7].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[5] = new Rectangle(grayBlocks[7].x, grayBlocks[11].y, blockWidth, blockHeight);
        yellowBlocks[6] = new Rectangle(grayBlocks[7].x, grayBlocks[10].y, blockWidth, blockHeight);
        yellowBlocks[7] = new Rectangle(grayBlocks[7].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[8] = new Rectangle(grayBlocks[1].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[9] = new Rectangle(grayBlocks[3].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[10] = new Rectangle(grayBlocks[0].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[11] = new Rectangle(grayBlocks[2].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[12] = new Rectangle(grayBlocks[6].x, grayBlocks[12].y, blockWidth, blockHeight);
        yellowBlocks[13] = new Rectangle(grayBlocks[1].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[14] = new Rectangle(grayBlocks[3].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[15] = new Rectangle(grayBlocks[0].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[16] = new Rectangle(grayBlocks[2].x, grayBlocks[9].y, blockWidth, blockHeight);
        yellowBlocks[17] = new Rectangle(grayBlocks[6].x, grayBlocks[9].y, blockWidth, blockHeight);
        //define all of the red blocks
        redBlocks[0] = new Rectangle(grayBlocks[6].x, grayBlocks[11].y, blockWidth, blockHeight);
        redBlocks[1] = new Rectangle(grayBlocks[3].x, grayBlocks[11].y, blockWidth, blockHeight);
        redBlocks[2] = new Rectangle(grayBlocks[2].x, grayBlocks[11].y, blockWidth, blockHeight);
        redBlocks[3] = new Rectangle(grayBlocks[1].x, grayBlocks[11].y, blockWidth, blockHeight);
        redBlocks[4] = new Rectangle(grayBlocks[0].x, grayBlocks[11].y, blockWidth, blockHeight);
        redBlocks[5] = new Rectangle(grayBlocks[6].x, grayBlocks[10].y, blockWidth, blockHeight);
        redBlocks[6] = new Rectangle(grayBlocks[3].x, grayBlocks[10].y, blockWidth, blockHeight);
        redBlocks[7] = new Rectangle(grayBlocks[2].x, grayBlocks[10].y, blockWidth, blockHeight);
        redBlocks[8] = new Rectangle(grayBlocks[1].x, grayBlocks[10].y, blockWidth, blockHeight);
        redBlocks[9] = new Rectangle(grayBlocks[0].x, grayBlocks[10].y, blockWidth, blockHeight);

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //if the ball exceeds the height have the ball go back to its start position and have it lose a life
            if (ball.y > HEIGHT) {
                ball.x = startBallX;
                ball.y = startBallY;
                ballYDirection = 0;
                ballXDirection = 0;
                lives = lives - 1;

            }
            //set the life points of the gray blocks to 1
            for (int i = 0; i < grayBlocks.length; i++) {
                grayBlockLife[i] = 1;
            }
            //set the life points of the yellow blocks tp 2
            for (int i = 0; i < yellowBlocks.length; i++) {
                if (yellowBlockFullLife) {
                    yellowBlockLife[i] = 2;
                }
            }
            //set the life points of the red blocks to 3
            for (int i = 0; i < redBlocks.length; i++) {
                if (redBlockFullLife) {
                    redBlockLife[i] = 3;
                }
            }
            //have the balls x and y value equal its direction times the ball's speed
            ball.x = ball.x + ballXDirection * ballSpeed;
            ball.y = ball.y + ballYDirection * ballSpeed;
            //if the ball exceeds the top border change the ball's Y direction
            if (ball.y < gBorderTop.y + gBorderTop.height) {
                ballYDirection = ballYDirection * -1;
            }
            //if the ball exceeds the left or right border change the ball's X direction
            if ((ball.x + ball.width > gBorderRight.x) || ball.x < gBorderLeft.x + gBorderLeft.width) {
                ballXDirection = ballXDirection * -1;
            }
            //if the ball intersects the left half of the paddle make the ball go towards the top left of the screen
            if (ball.intersects(playerPart1)) {
                ballXDirection = -1;
                ballYDirection = -1;
            }
            //if the ball intersects the right half of the paddle make the ball go towards the top right of the screen
            if (ball.intersects(playerPart2)) {
                ballXDirection = 1;
                ballYDirection = -1;
            }
            //if the ball intersects with the left or right side of the gray block change the X direction, likewise, if it hits the top or bottom
            //of the gray block change the Y direction, minus 1 life point, and delete the block depending on the amount of life points it has      //of the gray block change the Y direction
            for (int i = 0; i < grayBlocks.length; i++) {
                if (ball.intersects(grayBlocks[i])) {
                    int cHeight = Math.min(grayBlocks[i].y + grayBlocks[i].height, ball.y + ball.height) - Math.max(grayBlocks[i].y, ball.y);
                    int cWidth = Math.min(grayBlocks[i].x + grayBlocks[i].width, ball.x + ball.width) - Math.max(grayBlocks[i].x, ball.x);
                    if (cWidth < cHeight) {

                        ballXDirection = ballXDirection * -1;
                    } else {

                        ballYDirection = ballYDirection * -1;
                    }
                    grayBlockLife[i] = grayBlockLife[i] - 1;
                    if (grayBlockLife[i] == 0) {
                        grayBlocks[i].height = 0;
                        grayBlocks[i].width = 0;
                    }
                }
            }
            //if the ball intersects with the left or right side of the yellow block change the X direction, likewise, if it hits the top or bottom
            //of the yellow block change the Y direction, minus 1 life point, and delete the block depending on the amount of life points it has
            for (int i = 0; i < yellowBlocks.length; i++) {
                if (ball.intersects(yellowBlocks[i])) {
                    int cHeight = Math.min(yellowBlocks[i].y + yellowBlocks[i].height, ball.y + ball.height) - Math.max(yellowBlocks[i].y, ball.y);
                    int cWidth = Math.min(yellowBlocks[i].x + yellowBlocks[i].width, ball.x + ball.width) - Math.max(yellowBlocks[i].x, ball.x);
                    if (cWidth < cHeight) {

                        ballXDirection = ballXDirection * -1;
                    } else {

                        ballYDirection = ballYDirection * -1;
                    }
                    yellowBlockLife[i] = yellowBlockLife[i] - 1;
                    yellowBlockFullLife = false;

                    if (yellowBlockLife[i] == 0) {
                        yellowBlocks[i].height = 0;
                        yellowBlocks[i].width = 0;
                    }
                }
            }
            //if the ball intersects with the left or right side of the red block change the X direction, likewise, if it hits the top or bottom
            //of the red block change the Y direction, minus 1 life point, and delete the block depending on the amount of life points it has
            for (int i = 0; i < redBlocks.length; i++) {
                if (ball.intersects(redBlocks[i])) {
                    int cHeight = Math.min(redBlocks[i].y + redBlocks[i].height, ball.y + ball.height) - Math.max(redBlocks[i].y, ball.y);
                    int cWidth = Math.min(redBlocks[i].x + redBlocks[i].width, ball.x + ball.width) - Math.max(redBlocks[i].x, ball.x);
                    if (cWidth < cHeight) {
                        ballXDirection = ballXDirection * -1;
                    } else {
                        ballYDirection = ballYDirection * -1;
                    }
                    redBlockLife[i] = redBlockLife[i] - 1;
                    redBlockFullLife = false;
                    if (redBlockLife[i] == 0) {
                        redBlocks[i].height = 0;
                        redBlocks[i].width = 0;
                    }
                }
            }
            //see if all the gray blocks are destroyed
            for (int i = 0; i < grayBlocks.length; i++) {
                if (grayBlocks[i].width == 0) {
                    grayCounter = grayCounter + 1;
                } else {
                    grayCounter = 0;

                }
                if (grayCounter == grayBlocks.length) {
                    allGrayGone = true;
                    break;
                }
            }
            //see if all the yellow blocks are destroyed
            for (int i = 0; i < yellowBlocks.length; i++) {
                if (yellowBlocks[i].width == 0) {
                    yellowCounter = yellowCounter + 1;
                } else {
                    yellowCounter = 0;
                }
                if (yellowCounter == yellowBlocks.length) {
                    allYellowGone = true;
                    break;
                }

            }
            //see if all the red blocks are destroyed
            for (int i = 0; i < redBlocks.length; i++) {
                if (redBlocks[i].width == 0) {
                    redCounter = redCounter + 1;
                } else {
                    redCounter = 0;
                }
                if (redCounter == redBlocks.length) {
                    allRedGone = true;
                    break;
                }

            }
            //if the player is holding the left arrow key mvoe the paddle right unless there is a border in the way
            if (playerLeft && playerPart1.x > gBorderLeft.x + gBorderLeft.width * 2) {
                playerPart1.x = playerPart1.x - paddleSpeed;
                playerPart2.x = playerPart2.x - paddleSpeed;
            }
            //if the player is holding the right arrow key movee the paddle right unless there is a border in the way
            if (playerRight && playerPart1.x < (gBorderRight.x - paddleWidth)) {
                playerPart1.x = playerPart1.x + paddleSpeed;
                playerPart2.x = playerPart2.x + paddleSpeed;
            }

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
            //get the key code
            int key = e.getKeyCode();
            //see if the left, right, or enter keys are being pressed
            if (key == KeyEvent.VK_LEFT) {
                playerLeft = true;
            } else if (key == KeyEvent.VK_RIGHT) {
                playerRight = true;
            } else if (key == KeyEvent.VK_ENTER) {
                enter = true;
            }

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            //get the key code
            int key = e.getKeyCode();
            //see if the left, right, or enter keys are being released
            if (key == KeyEvent.VK_LEFT) {
                playerLeft = false;
            } else if (key == KeyEvent.VK_RIGHT) {
                playerRight = false;
            }
            if (key == KeyEvent.VK_ENTER) {
                enter = false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        Game_Summative game = new Game_Summative();

        // starts the game loop
        game.run();
    }
}
