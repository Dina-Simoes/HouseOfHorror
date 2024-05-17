package Entity;

import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Entity {

    public int worldX;
    public int worldY;
    public int speed;
    GamePanel gamePanel;

    public String name;
    public String direction;

    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn=false;

    public Picture picture;

    //CHARACTER STATUS
    public int maxLife;
    public int life;






}
