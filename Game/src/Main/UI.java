package Main;

import Objects.OBJ_Pizza;
import Objects.OBJ_duck;
import Objects.OBJ_heart;
import Objects.OBJ_iceCream;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    public Text duckCounter=new Text(7*GamePanel.tileSize,1*GamePanel.tileSize, "x"+String.valueOf(OBJ_duck.duckCounter));
    public Picture duckPictureCounter=new Picture(5.5*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\duck.png");
    public Text pizzaCounter=new Text(10*GamePanel.tileSize,1*GamePanel.tileSize,"x"+String.valueOf(OBJ_Pizza.pizzaCounter));
    public Picture pizzaPictureCounter=new Picture(8.5*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\pizza.png");
    public Text iceCreamCounter=new Text(13*GamePanel.tileSize,1*GamePanel.tileSize,"x"+String.valueOf(OBJ_iceCream.iceCreamCounter));
    public Picture iceCreamPictureCounter=new Picture(11.5*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\icecream.png");
    public boolean gameFinished=false;

    //Display player Life
    public Picture heartPicture=new Picture(23*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\heart.png");
    public Picture heartPicture2=new Picture(22*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\heart.png");
    public Picture heartPicture3=new Picture(21*GamePanel.tileSize,1*GamePanel.tileSize,"\\Objects\\heart.png");


    public UI(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        DisplayStatus();
    }

public void DisplayStatus(){
    //Duck counter
    duckCounter.grow(GamePanel.tileSize/2, GamePanel.tileSize/2);
    duckCounter.setColor(Color.WHITE);
    duckCounter.draw();
    duckPictureCounter.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    duckPictureCounter.draw();
    //pizza counter
    pizzaCounter.grow(GamePanel.tileSize/2, GamePanel.tileSize/2);
    pizzaCounter.setColor(Color.WHITE);
    pizzaCounter.draw();
    pizzaPictureCounter.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    pizzaPictureCounter.draw();
    //icecream counter
    iceCreamCounter.grow(GamePanel.tileSize/2, GamePanel.tileSize/2);
    iceCreamCounter.setColor(Color.WHITE);
    iceCreamCounter.draw();
    iceCreamPictureCounter.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    iceCreamPictureCounter.draw();
    //Player Life
    heartPicture.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    heartPicture.draw();
    heartPicture2.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    heartPicture2.draw();
    heartPicture3.grow(GamePanel.tileSize/4,GamePanel.tileSize/4);
    heartPicture3.draw();
}

}
