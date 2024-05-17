package Main;

import Entity.CollisionChecker;
import Entity.Player;
import Tile.TileManager;
import monster.MON_red;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MonsterSetter extends Thread{
    static GamePanel gamePanel;
    CollisionChecker collisionChecker;
    public MonsterSetter(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }
    public void setMonster() {
        gamePanel.monster[0] = new MON_red(gamePanel);
        gamePanel.monster[0].worldX = 3 * GamePanel.tileSize;
        gamePanel.monster[0].worldY = 4 * GamePanel.tileSize;
        gamePanel.monster[0].picture = new Picture(gamePanel.monster[0].worldX, gamePanel.monster[0].worldY, "\\monster\\monster2\\down1.png");
        gamePanel.monster[0].picture.grow((GamePanel.tileSize - GamePanel.originalTileSize) / 2, (GamePanel.tileSize - GamePanel.originalTileSize) / 2);
        gamePanel.monster[0].picture.draw();

        gamePanel.monster[1] = new MON_red(gamePanel);
        gamePanel.monster[1].worldX = 9 * GamePanel.tileSize;
        gamePanel.monster[1].worldY = 9 * GamePanel.tileSize;
        gamePanel.monster[1].picture = new Picture(gamePanel.monster[1].worldX, gamePanel.monster[1].worldY, "\\monster\\monster2\\down1.png");
        gamePanel.monster[1].picture.grow((GamePanel.tileSize - GamePanel.originalTileSize) / 2, (GamePanel.tileSize - GamePanel.originalTileSize) / 2);
        gamePanel.monster[1].picture.draw();

        gamePanel.monster[2] = new MON_red(gamePanel);
        gamePanel.monster[2].worldX = 23 * GamePanel.tileSize;
        gamePanel.monster[2].worldY = 9 * GamePanel.tileSize;
        gamePanel.monster[2].picture = new Picture(gamePanel.monster[2].worldX, gamePanel.monster[2].worldY, "\\monster\\monster2\\down1.png");
        gamePanel.monster[2].picture.grow((GamePanel.tileSize - GamePanel.originalTileSize) / 2, (GamePanel.tileSize - GamePanel.originalTileSize) / 2);
        gamePanel.monster[2].picture.draw();
    }

    public static Thread monster0=new Thread(new Runnable() {
        @Override
        public void run() {

            double drawInterval=1000000000/ gamePanel.FPS;
            double delta=0;
            long lastTime=System.nanoTime();
            long currentTime;
            long timer=0;
            int drawCount=0;

            while (monster0!=null){

                currentTime=System.nanoTime();
                delta+=(currentTime-lastTime)/drawInterval;
                timer+=(currentTime-lastTime);
                lastTime=currentTime;

                if(delta>=1) {
                    delta--;
                    drawCount++;
                }

                if(timer>=1000000000){
                    System.out.println("FPS:"+drawCount);
                    drawCount=0;
                    timer=0;
                }

                try {
                    if (gamePanel.monster[0]!=null) {
                        gamePanel.monster[0].setActionH(3 * GamePanel.tileSize, 7 * GamePanel.tileSize);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    );

    public static Thread monster1=new Thread(new Runnable() {
        @Override
        public void run() {

            double drawInterval=1000000000/ gamePanel.FPS;
            double delta=0;
            long lastTime=System.nanoTime();
            long currentTime;
            long timer=0;
            int drawCount=0;

            while (monster1!=null){

                currentTime=System.nanoTime();
                delta+=(currentTime-lastTime)/drawInterval;
                timer+=(currentTime-lastTime);
                lastTime=currentTime;

                if(delta>=1) {
                    delta--;
                    drawCount++;
                }

                if(timer>=1000000000){
                    System.out.println("FPS:"+drawCount);
                    drawCount=0;
                    timer=0;
                }

                try {
                    if (gamePanel.monster[1]!=null) {
                        gamePanel.monster[1].setActionV(9 * GamePanel.tileSize, 14 * GamePanel.tileSize);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    });

    public static Thread monster2=new Thread(new Runnable() {
        @Override
        public void run() {

            double drawInterval=1000000000/ gamePanel.FPS;
            double delta=0;
            long lastTime=System.nanoTime();
            long currentTime;
            long timer=0;
            int drawCount=0;

            while (monster2!=null){

                currentTime=System.nanoTime();
                delta+=(currentTime-lastTime)/drawInterval;
                timer+=(currentTime-lastTime);
                lastTime=currentTime;

                if(delta>=1) {
                    delta--;
                    drawCount++;
                }

                if(timer>=1000000000){
                    System.out.println("FPS:"+drawCount);
                    drawCount=0;
                    timer=0;
                }

                try {
                    if (gamePanel.monster[2]!=null) {
                        gamePanel.monster[2].setActionV(9 * GamePanel.tileSize, 14 * GamePanel.tileSize);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });



}


