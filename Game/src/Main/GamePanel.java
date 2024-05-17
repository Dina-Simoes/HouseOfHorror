package Main;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;

import Entity.Entity;
import Objects.SuperObject;
import monster.MON_red;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GamePanel implements Runnable {

    //ATTRIBUTES
    //SCREEN SETTINGS
    public static int originalTileSize=32;  //16x16 tile
    final static double scale=1.5;  // scale x times real size
    public static int PADDING=10;  // pixels padding
    public static int tileSize=(int)(originalTileSize*scale);  //48x48 tile
    static public final int maxScreenCol=24;  // 16 columns horizontally
    static public final int maxScreenRow=18;  //12 rows vertically
    public static final int screenWidth=tileSize*(maxScreenCol);   //768 pixels
    public static final int screenHeight=tileSize*(maxScreenRow);  //576 pixels

    //FPS
    int FPS=60;

    Thread gameThread;
    public AssetSetter assetSetter=new AssetSetter(this);
    public MonsterSetter monsterSetter=new MonsterSetter(this);
    public SuperObject superObject[]=new SuperObject[9];
    public MON_red monster[]=new MON_red[3];

    public GamePanel() throws IOException {

    }

    public void setupGame(){
        assetSetter.setObject();
        monsterSetter.setMonster();
    }

    @Override
    public void run() {

        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while (gameThread!=null){

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

        }


    }
}
