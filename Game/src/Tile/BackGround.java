package Tile;

import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BackGround {

    GamePanel gamePanel;

    // Background default values
    public static int defaultBackgroundX;
    public static int defaultBackgroundY;

    public BackGround(GamePanel gamePanel){

        this.gamePanel=gamePanel;
        defaultBackgroundX=GamePanel.PADDING;
        defaultBackgroundY=GamePanel.PADDING;
        Picture backGroundPicture =new Picture(defaultBackgroundX,defaultBackgroundY,"\\Tiles\\bg.png");
        backGroundPicture.draw();
    }




}
