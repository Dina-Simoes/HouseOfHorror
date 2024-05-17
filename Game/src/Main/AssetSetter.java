package Main;

import Objects.*;
import monster.MON_red;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.TimerTask;

public class AssetSetter extends Thread {

    static GamePanel gamePanel;
    Thread gameThread;

    public AssetSetter(GamePanel gamePanel){
        this.gamePanel=gamePanel;
    }

    public void setObject(){

        gamePanel.superObject[0]=new OBJ_Pizza();
        gamePanel.superObject[0].objWorldX=19*GamePanel.tileSize;
        gamePanel.superObject[0].objWorldY=9*GamePanel.tileSize;
        gamePanel.superObject[0].objPicture=new Picture(gamePanel.superObject[0].objWorldX,gamePanel.superObject[0].objWorldY,"\\Objects\\pizza.png");
        gamePanel.superObject[0].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[0].objPicture.draw();

        gamePanel.superObject[1]=new OBJ_duck();
        gamePanel.superObject[1].objWorldX=7*GamePanel.tileSize;
        gamePanel.superObject[1].objWorldY=15*GamePanel.tileSize;
        gamePanel.superObject[1].objPicture=new Picture(gamePanel.superObject[1].objWorldX,gamePanel.superObject[1].objWorldY,"\\Objects\\duck.png");
        gamePanel.superObject[1].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[1].objPicture.draw();

        gamePanel.superObject[2]=new OBJ_iceCream();
        gamePanel.superObject[2].objWorldX=16*GamePanel.tileSize;
        gamePanel.superObject[2].objWorldY=12*GamePanel.tileSize;
        gamePanel.superObject[2].objPicture=new Picture(gamePanel.superObject[2].objWorldX,gamePanel.superObject[2].objWorldY,"\\Objects\\icecream.png");
        gamePanel.superObject[2].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[2].objPicture.draw();

        gamePanel.superObject[3]=new OBJ_Pizza();
        gamePanel.superObject[3].objWorldX=5*GamePanel.tileSize;
        gamePanel.superObject[3].objWorldY=3*GamePanel.tileSize;
        gamePanel.superObject[3].objPicture=new Picture(gamePanel.superObject[3].objWorldX,gamePanel.superObject[3].objWorldY,"\\Objects\\pizza.png");
        gamePanel.superObject[3].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[3].objPicture.draw();

        gamePanel.superObject[4]=new OBJ_duck();
        gamePanel.superObject[4].objWorldX=17*GamePanel.tileSize;
        gamePanel.superObject[4].objWorldY=3*GamePanel.tileSize;
        gamePanel.superObject[4].objPicture=new Picture(gamePanel.superObject[4].objWorldX,gamePanel.superObject[4].objWorldY,"\\Objects\\duck.png");
        gamePanel.superObject[4].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[4].objPicture.draw();

        gamePanel.superObject[5]=new OBJ_iceCream();
        gamePanel.superObject[5].objWorldX=1*GamePanel.tileSize;
        gamePanel.superObject[5].objWorldY=7*GamePanel.tileSize;
        gamePanel.superObject[5].objPicture=new Picture(gamePanel.superObject[5].objWorldX,gamePanel.superObject[5].objWorldY,"\\Objects\\icecream.png");
        gamePanel.superObject[5].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[5].objPicture.draw();

        gamePanel.superObject[7]=new OBJ_skate();
        gamePanel.superObject[7].objWorldX=9*GamePanel.tileSize;
        gamePanel.superObject[7].objWorldY=6*GamePanel.tileSize;
        gamePanel.superObject[7].objPicture=new Picture(gamePanel.superObject[7].objWorldX,gamePanel.superObject[7].objWorldY,"\\Objects\\skate.png");
        gamePanel.superObject[7].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[7].objPicture.draw();

        gamePanel.superObject[8]=new OBJ_paint();
        gamePanel.superObject[8].objWorldX=19*GamePanel.tileSize;
        gamePanel.superObject[8].objWorldY=4*GamePanel.tileSize;
        gamePanel.superObject[8].objPicture=new Picture(gamePanel.superObject[8].objWorldX,gamePanel.superObject[8].objWorldY,"\\Objects\\ferrao.png");
        gamePanel.superObject[8].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
        gamePanel.superObject[8].objPicture.draw();
    }
}
