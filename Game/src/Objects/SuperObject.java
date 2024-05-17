package Objects;
import java.awt.*;
import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SuperObject {

    public Picture objPicture;
    public String name;
    public boolean collision=false;
    public int objWorldX, objWorldY;

    public java.awt.Rectangle solidArea=new Rectangle(0,0,GamePanel.tileSize,GamePanel.tileSize);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;



}
