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
    int borderSpace = 30;
    Rectangle playerPart1 = new Rectangle((WIDTH / 2) - (paddleWidth / 2), HEIGHT - 50, paddleWidth / 2, paddleHeight / 2);
    Rectangle playerPart2 = new Rectangle(playerPart1.x + playerPart1.width, HEIGHT - 50, playerPart1.width, playerPart1.height);
    
    Rectangle[] grayBlocks = new Rectangle[26];
    Rectangle[] yellowBlocks = new Rectangle[18];
    Rectangle[] redBlocks = new Rectangle[10];
    
    Rectangle gBorderLeft = new Rectangle(borderSpace, borderSpace, 7, HEIGHT);
    Rectangle gBorderRight = new Rectangle(WIDTH - borderSpace - 1, borderSpace, 7, HEIGHT);
    Rectangle gBorderTop = new Rectangle(borderSpace, borderSpace, WIDTH - borderSpace * 2 - 1, 7);
    int[] grayBlockLife = new int[grayBlocks.length];
    int[] yellowBlockLife = new int[yellowBlocks.length];
    int[] redBlockLife = new int[redBlocks.length];
    int blockHeight = 25;
    int blockWidth = 50;
    int ballHeight = 25;
    int ballWidth = 25;
    int startBallX = (WIDTH / 2) - (ballWidth / 2);
    int startBallY = playerPart1.y - 100;
    int blockSpace = 25;
    Rectangle ball = new Rectangle((WIDTH / 2) - (ballWidth / 2), playerPart1.y - 100, ballWidth, ballHeight);
    int paddleSpeed = 12;
    int ballSpeed = 6;
    int ballXDirection = 0;
    int ballYDirection = 0;
    int lives = 3;
    boolean playerLeft = false;
    boolean playerRight = false;
    boolean enter = false;
    boolean yellowBlockFullLife = true;
    boolean redBlockFullLife = true;
    boolean allGrayGone = false;
    boolean allYellowGone = false;
    boolean allRedGone = false;
    int grayCounter = 0;
    int yellowCounter = 0;
    int redCounter = 0;
    Font biggerFont = new Font("Swis721 BlkOul BT", Font.BOLD, 60);
    Font font = new Font("Swis721 BlkOul BT", Font.BOLD, 42);
    Font smallerFont = new Font("Swis721 BlkOul BT", Font.BOLD, 22);
    Color candyRed = new Color(217, 0, 101);
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

        
            g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < grayBlocks.length; i++) {
            g.setColor(Color.GRAY);
            if (grayBlocks[i] != null) {
                g.fillRect(grayBlocks[i].x, grayBlocks[i].y, grayBlocks[i].width, grayBlocks[i].height);
            }
        }
        for (int i = 0; i < yellowBlocks.length; i++) {
            g.setColor(Color.YELLOW);
            if (yellowBlockLife[i] == 1) {
                g.setColor(Color.GRAY);
            }

            if (yellowBlocks[i] != null) {
                g.fillRect(yellowBlocks[i].x, yellowBlocks[i].y, yellowBlocks[i].width, yellowBlocks[i].height);
            }
        }
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
        if (ballYDirection == 0) {
            g.setColor(Color.WHITE);
            g.setFont(biggerFont);
            g.drawString("Block", (WIDTH / 2) - 95, 190);
            g.drawString("Breaker", (WIDTH / 2) - 134, 250);
            g.setFont(font);
            g.drawString("Press ENTER to Start", (WIDTH / 2) - 250, HEIGHT / 2 + 100);
            if (enter) {
                ballYDirection = 1;
            }
        }
        g.setFont(smallerFont);
        g.setColor(skyBlue);
        g.drawString("Lives Left: " + lives, WIDTH - 180, 23);
        g.fillRect(playerPart1.x, playerPart1.y, playerPart1.width, playerPart1.height);
        g.fillRect(playerPart2.x, playerPart2.y, playerPart2.width, playerPart2.height);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        g.fillRect(gBorderLeft.x, gBorderLeft.y, gBorderLeft.width, gBorderLeft.height);
        g.fillRect(gBorderRight.x, gBorderRight.y, gBorderRight.width, gBorderRight.height);
        g.fillRect(gBorderTop.x, gBorderTop.y, gBorderTop.width, gBorderTop.height);
        
        if(lives<=0){
        g.setFont(biggerFont);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("You Lose", (WIDTH / 2) - 210, HEIGHT / 2 + 100);
        }
        if(allGrayGone){
        g.setFont(biggerFont);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("You Win!", (WIDTH / 2) - 210, HEIGHT / 2 + 100);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        //Any of your pre setup before the loop starts should go here
        grayBlocks[0] = new Rectangle((WIDTH / 2) - (blockWidth / 2), (HEIGHT / 2) - (blockHeight / 2) + 25, blockWidth, blockHeight);
        grayBlocks[1] = new Rectangle(grayBlocks[0].x - blockWidth - blockSpace, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[2] = new Rectangle(grayBlocks[0].x + blockWidth + blockSpace, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[3] = new Rectangle(grayBlocks[0].x - (blockWidth*2) - (blockSpace*2), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[4] = new Rectangle(grayBlocks[0].x - (blockWidth*3) - (blockSpace*3), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[5] = new Rectangle(grayBlocks[0].x - (blockWidth*4) - (blockSpace*4), grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[6] = new Rectangle(grayBlocks[0].x + blockWidth*2 + blockSpace*2, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[7] = new Rectangle(grayBlocks[0].x + blockWidth*3 + blockSpace*3, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[8] = new Rectangle(grayBlocks[0].x + blockWidth*4 + blockSpace*4, grayBlocks[0].y, blockWidth, blockHeight);
        grayBlocks[9] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace*2, blockWidth, blockHeight);
        grayBlocks[10] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace*4, blockWidth, blockHeight);
        grayBlocks[11] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace*6, blockWidth, blockHeight);
        grayBlocks[12] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace*8, blockWidth, blockHeight);
        grayBlocks[13] = new Rectangle(grayBlocks[8].x, grayBlocks[0].y - blockSpace*10, blockWidth, blockHeight);
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
            if (ball.y > HEIGHT) {
                ball.x = startBallX;
                ball.y = startBallY;
                ballYDirection = 0;
                ballXDirection = 0;
                lives = lives - 1;

            }

            for (int i = 0; i < grayBlocks.length; i++) {
                grayBlockLife[i] = 1;
            }
            for (int i = 0; i < yellowBlocks.length; i++) {
                if (yellowBlockFullLife) {
                    yellowBlockLife[i] = 2;
                }
            }
            for (int i = 0; i < redBlocks.length; i++) {
                if (redBlockFullLife) {
                    redBlockLife[i] = 3;
                }
            }
            ball.x = ball.x + ballXDirection * ballSpeed;
            ball.y = ball.y + ballYDirection * ballSpeed;
            if (ball.y < gBorderTop.y + gBorderTop.height) {
                ballYDirection = ballYDirection * -1;
            }
            if ((ball.x + ball.width > gBorderRight.x) || ball.x < gBorderLeft.x + gBorderLeft.width) {
                ballXDirection = ballXDirection * -1;
            }
            if (ball.intersects(playerPart1)) {
                ballXDirection = -1;
                ballYDirection = -1;
            }

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
            for(int i = 0; i < grayBlocks.length; i++){
                if(grayBlocks[i].width == 0){
                    grayCounter = grayCounter + 1;
                }else{
                    grayCounter = 0;
                }
                if(grayCounter == grayBlocks.length){
                    allGrayGone = true;
                    break;
                }
                
            }
            for(int i = 0; i < yellowBlocks.length; i++){
                if(yellowBlocks[i].width == 0){
                    yellowCounter = yellowCounter + 1;
                }else{
                    yellowCounter = 0;
                }
                if(yellowCounter == yellowBlocks.length){
                    allYellowGone = true;
                    break;
                }
                
            }
            for(int i = 0; i < redBlocks.length; i++){
                if(redBlocks[i].width == 0){
                    redCounter = redCounter + 1;
                }else{
                    redCounter = 0;
                }
                if(redCounter == redBlocks.length){
                    allRedGone = true;
                    break;
                }
                
            }

            if (ball.intersects(playerPart2)) {
                ballXDirection = 1;
                ballYDirection = -1;
            }
            if (playerLeft && playerPart1.x > gBorderLeft.x + gBorderLeft.width) {
                playerPart1.x = playerPart1.x - paddleSpeed;
                playerPart2.x = playerPart2.x - paddleSpeed;
            }
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
