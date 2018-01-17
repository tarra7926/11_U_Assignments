/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
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
    int paddleWidth = 100;
    int paddleHeight = 20;
    Rectangle playerPart1 = new Rectangle((WIDTH / 2) - (paddleWidth / 2), HEIGHT - 50, paddleWidth / 2, paddleHeight / 2);
    Rectangle playerPart2 = new Rectangle(playerPart1.x + playerPart1.width, HEIGHT - 50, playerPart1.width, playerPart1.height);
    Rectangle[] grayBlocks = new Rectangle[1];
    int blockHeight = 300;
    int blockWidth = 300;
    int ballHeight = 25;
    int ballWidth = 25;
    Rectangle ball = new Rectangle((WIDTH / 2) - (ballWidth / 2), playerPart1.y - 100, ballWidth, ballHeight);
    int paddleSpeed = 7;
    int ballSpeed = 5;
    int ballXDirection = 0;
    int ballYDirection = 0;
    boolean playerLeft = false;
    boolean playerRight = false;
    boolean startPosition = true;
    boolean enter = false;
    Font font = new Font("Swis721 BlkOul BT", Font.BOLD, 42);
    Color candyRed = new Color(217, 0, 101);
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

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < grayBlocks.length; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(grayBlocks[i].x, grayBlocks[i].y, grayBlocks[i].width, grayBlocks[i].height);
        }
        g.fillRect(playerPart1.x, playerPart1.y, playerPart1.width, playerPart1.height);
        g.fillRect(playerPart2.x, playerPart2.y, playerPart2.width, playerPart2.height);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        g.setColor(candyRed);

        if (ballYDirection == 0) {
            g.drawString("Press enter to Start", (WIDTH / 2) - 240, HEIGHT / 2 + 100);
            if (enter) {
                ballYDirection = 1;
            }
        }

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        grayBlocks[0] = new Rectangle((WIDTH / 2) - (blockWidth / 2), (HEIGHT / 2) - (blockHeight / 2), blockWidth, blockHeight);

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
            if (playerPart1.x == (WIDTH / 2) - (paddleWidth / 2) && ball.x == (WIDTH / 2) - (ballWidth / 2)) {
                startPosition = true;
            } else {
                startPosition = false;
            }



            ball.x = ball.x + ballXDirection * ballSpeed;
            ball.y = ball.y + ballYDirection * ballSpeed;
            if (ball.y + ball.height > HEIGHT || ball.y < 0) {
                ballYDirection = ballYDirection * -1;
            }
            if ((ball.x + ball.width > WIDTH) || ball.x < 0) {
                ballXDirection = ballXDirection * -1;
            }
            if (ball.intersects(playerPart1)) {
                ballXDirection = -1;
                ballYDirection = -1;
            }
            for (int i = 0; i < grayBlocks.length; i++) {
                if (ball.intersects(grayBlocks[i])) {
                    if(ball.y + ball.height > grayBlocks[i].y || ball.y < grayBlocks[i].y + grayBlocks[i].height){
                        ballYDirection = ballYDirection * -1;
                    } else {
                        ballXDirection = ballXDirection * -1;
                    }
                }
            }
            if (ball.intersects(playerPart2)) {
                ballXDirection = 1;
                ballYDirection = -1;
            }
            if (playerLeft && playerPart1.x > 0) {
                playerPart1.x = playerPart1.x - paddleSpeed;
                playerPart2.x = playerPart2.x - paddleSpeed;
            }
            if (playerRight && playerPart1.x < (WIDTH - paddleWidth)) {
                playerPart1.x = playerPart1.x + paddleSpeed;
                playerPart2.x = playerPart2.x + paddleSpeed;
            }
            if (playerPart1.x == (WIDTH / 2) - (paddleWidth / 2) && ball.x == (WIDTH / 2) - (ballWidth / 2)) {
                startPosition = true;
            } else {
                startPosition = false;
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
            int key = e.getKeyCode();
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
            int key = e.getKeyCode();
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
