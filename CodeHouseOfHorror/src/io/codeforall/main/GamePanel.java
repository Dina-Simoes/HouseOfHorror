package io.codeforall.main;

import io.codeforall.entity.Player;
import io.codeforall.tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //ATTRIBUTES
    //SCREEN SETTINGS
    final int originalTileSize = 16;  //16x16 tile
    final int scale=7; //pc graphics scale!!!!
    public final int tileSize= originalTileSize*scale; //48x48 tile
    public final int maxScreenCol=16; //16 columns
    public final int maxScreenRow=12;  //12 rows
    public final int screenWidth=tileSize*maxScreenCol; //screen width 769 pixels
    public final int screenHeight=tileSize*maxScreenRow; //screen height 576 pixels


    //FPS
    int FPS=60; //Game frames per second

    TileManager tileManager=new TileManager(this);

    KeyHandler keyHandler= new KeyHandler();
    Thread gameThread;  //game clock
    Player player=new Player(this, keyHandler);

    //CONSTRUCTOR
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));  // set screen size
        this.setBackground(Color.BLACK);  //set screen backround color
        this.setDoubleBuffered(true); // improve game rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true);  //gamePanel can be focused to receive key input
    }

    public void startGameThread(){

        gameThread=new Thread(this); //new Thread of gamePanel
        gameThread.start();  //start object gameThread
    }


    public void run(){

        // "DELTA/ACCUMULATOR METHOD" to create a game loop
        double drawInterval= 1000000000/FPS;
        double delta = 0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount=0;

        while (gameThread!=null){

            //Estabelecer os FPS em 60
            currentTime=System.nanoTime();

            delta+=(currentTime-lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime= currentTime;

            if (delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;

            }
            //Printer dos FPS
            if(timer>=1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount=0;
                timer=0;

            }
        }

    }


    // update information
    public void update(){

      player.update();

    }

    //draw on the screen update information
    //Graphics class - has many functions to draw objets on the screen
    public void paintComponent(Graphics g){

        super.paintComponent(g);  //

        Graphics2D g2=(Graphics2D)g; //graphics 2D have more functions

        tileManager.draw(g2); //draw tiles first, only after we put the player

        player.draw(g2);
        g2.dispose();
    }
}
