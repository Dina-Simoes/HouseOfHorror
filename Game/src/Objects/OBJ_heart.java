package Objects;

import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class OBJ_heart extends SuperObject{

    public static int heartCounter=0;
    public Picture heartPicture;
    public Picture heartPicture2;
    public Picture heartPicture3;


    public OBJ_heart(){
        name="Heart";
        collision=false;


    }


}
